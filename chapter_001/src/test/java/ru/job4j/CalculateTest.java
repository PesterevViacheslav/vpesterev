package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class CalculateTest Автотесты для задач Части 001. Базовый синтаксис урок 1.
*
* @author Viacheslav Pesterev (pesterevvv@gmail.com)
* @since 06.03.2018
* @version 1
*/
public class CalculateTest {

  /**
    * Test echo.
    */ @Test
  public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Viacheslav Pesterev";
    String expect = "Echo, echo, echo : Viacheslav Pesterev"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
  }
}