package ru.job4j.lambda;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * Class AttachmentSort - Сортировка с компаратором. Решение задач уровня Стажер. Части 04. FP, Lambda, Stream API.
 * 1. Lambda. 1. Анонимные классы [#214142].
 *
 * @author Viacheslav Pesterev (pesterevvv@gmail.com)
 * @since 11.05.2020
 * @version 1
 */
public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13),
                new Attachment(null, 1)
        );
        Comparator comparator =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        Comparator comparatorByName =  new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (left.getName() == null) {
                    return -1;
                }
                if (right.getName() == null) {
                    return 1;
                }
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return left.getName().compareTo(right.getName());
            }
        };
        attachments.sort(comparatorByName);
        System.out.println(attachments);
    }
}