package ru.job4j.bombermen;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Class Board - Игра Бомбермен. Решение задач уровня Middle. Части 001. Multithreading.
 * 10.7.1. Игра Бомбермен.
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 06.02.2019
 * @version 1
 */
public class Board {
    private final Cell[][] board;
    private static final String WRECK = "XXXXXXXX";
    private static final String BLANK = "--------";
    private int stopCount;
    /**
     * Method Board. Конструктор.
     * @param size Размер поля.
     */
    public Board(int size, int stopCount) {
        this.board = new Cell[size][size];
        this.stopCount = stopCount;
    }
    /**
     * Method init. Первоначальное заполнение доски.
     * @param blocksCount Число препятствий.
     */
    public void init(int blocksCount) {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                this.board[i][j] = new Cell(i, j, new ReentrantLock(), BLANK);
            }
        }
        for (int i = 0; i < blocksCount; i++) {
            int x = (int) Math.ceil(Math.random() * this.board.length - 1);
            int y = (int) Math.ceil(Math.random() * this.board.length - 1);
            if (this.board[x][y].lock.isLocked()) {
                i--;
            } else {
                this.board[x][y].lock.lock();
                this.board[x][y].blockType = WRECK;
            }
        }
    }
    /**
     * Method getFreeCell. Получение свободной клетки.
     */
    public Cell getFreeCell() throws InterruptedException {
        Cell res = null;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j].blockType.equals(BLANK) && this.board[i][j].lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                    res = this.board[i][j];
                    res.blockType = Thread.currentThread().getName();
                    return res;
                }
            }
        }
        if (res == null) {
            throw new InterruptedException("getFreeCell exception");
        }
        return res;
    }
    /**
     * Method print. Вывод текущего состояния игрового поля.
     */
    public void print() {
        StringBuilder result = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                result.append(this.board[i][j].blockType + " ");
            }
            result.append(ln);
        }
        System.out.println(result.toString());
    }
    /**
     * Method addMonster. Добавление монстра на доску.
     * @param name Имя.
     */
    public void addMonster(String name) {
        int tryCount = 0;
        while (tryCount <= 10) {
            Thread t = new Thread(() -> {
                try {
                    this.move(this.getFreeCell(), null);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupt");
                    Thread.currentThread().interrupt();
                }
            });
            if (!t.isInterrupted()) {
                t.setName(name);
                t.start();
                break;
            } else {
                tryCount++;
            }
        }
    }
    /**
     * Method calcFreeCell. Поиск свободной клетки.
     * @param src Исходная клетка.
     * @param dest Клетка назначения.
     * @return Свободная клетка.
     */
    private Cell calcFreeCell(Cell src, Cell dest) throws InterruptedException {
        int rnd = (int) Math.ceil(Math.random() * 4);
        dest = null;
        if (rnd == 1 && src.x + 1 < this.board.length) {
            if (this.board[src.x + 1][src.y].lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                dest = this.board[src.x + 1][src.y];
            }
        } else if (rnd == 2 && src.x - 1 >= 0) {
            if (this.board[src.x - 1][src.y].lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                dest = this.board[src.x - 1][src.y];
            }
        } else if (rnd == 3 && src.y + 1 < this.board.length) {
            if (this.board[src.x][src.y + 1].lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                dest = this.board[src.x][src.y + 1];
            }
        } else if (rnd == 4 && src.y - 1 >= 0) {
            if (this.board[src.x][src.y - 1].lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                dest = this.board[src.x][src.y - 1];
            }
        }
        return dest;
    }
    /**
     * Method move. Перемещение по игровому полю.
     * @param source Исходная клетка.
     * @param destination Клетка назначения.
     * @return Удалось ли сделать ход.
     */
    public boolean move(Cell source, Cell destination) throws InterruptedException {
        boolean res = false;
        Cell src = source;
        Cell dest = destination;
        int tryCount = 0;
        int stopCnt = 0;
        if (dest != null) {
            res = this.board[dest.x][dest.y].lock.tryLock(500, TimeUnit.MILLISECONDS);
            if (res) {
                this.board[src.x][src.y].blockType = BLANK;
                this.board[src.x][src.y].lock.unlock();
                this.board[dest.x][dest.y].blockType = Thread.currentThread().getName();
            }
        } else {
            while ((dest != null || tryCount <= 10) && stopCnt <= this.stopCount) {
                dest = calcFreeCell(src, dest);
                if (dest != null) {
                    this.board[src.x][src.y].blockType = BLANK;
                    this.board[src.x][src.y].lock.unlock();
                    this.board[dest.x][dest.y].blockType = Thread.currentThread().getName();
                    src = dest;
                    tryCount = 0;
                } else {
                    tryCount++;
                }
                Thread.sleep(1000);
                stopCnt++;
            }
        }
        return res;
    }
    /**
     * Method addHero. Добавление героя на доску.
     */
    public void runHero() {
        Thread t = new Thread(() -> {
            try {
                int step = 0;
                Cell startCell = this.getFreeCell();
                Cell destCell = null;
                Scanner in = new Scanner(System.in);
                System.out.println("Enter 1 - to move RIGHT, 2 - to move LEFT, 3 - to move UP, 4 - to move DOWN, 5 - to STOP");
                while (step != 5) {
                    this.print();
                    step = in.nextInt();
                    if (step == 1 && startCell.y - 1 >= 0) {
                        destCell = this.board[startCell.x][startCell.y - 1];
                    } else if (step == 2 && startCell.y + 1 < this.board.length) {
                        destCell = this.board[startCell.x][startCell.y + 1];
                    } else if (step == 3 && startCell.x - 1 >= 0) {
                        destCell = this.board[startCell.x - 1][startCell.y];
                    } else if (step == 4 && startCell.x + 1 < this.board.length) {
                        destCell = this.board[startCell.x + 1][startCell.y];
                    } else if (step != 5) {
                        System.out.println("Wrong cell");
                        destCell = null;
                    }
                    if (destCell != null) {
                        if (!this.move(startCell, destCell)) {
                            System.out.println("Cell blocked");
                        } else {
                            startCell = destCell;
                        }
                    }
                    if (step == 5) {
                        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
                        for (Thread tr : threadSet) {
                            if (tr.getName().contains("MONSTER")) {
                              tr.interrupt();
                              System.out.println("Thread :" + tr.getName() + " INTERRUPTED");
                            }
                        }
                        Thread.currentThread().interrupt();
                        System.out.println("Thread :" + Thread.currentThread().getName() + " INTERRUPTED");
                        System.out.println("EXIT");
                    } else {
                        System.out.println("Enter 1 - to move RIGHT, 2 - to move LEFT, 3 - to move UP, 4 - to move DOWN, 5 - to STOP");
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupt");
                Thread.currentThread().interrupt();
            }
        });
        t.setName("IM_HERO");
        t.start();
    }
}