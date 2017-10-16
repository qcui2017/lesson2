package com.beyondh.lesson2.serviceImpl;

import com.beyondh.lesson2.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    private static final String Sepertor=",";

    @Override
    public String genData() {
        StringBuffer builder=new StringBuffer();
        long begin = System.nanoTime();
        int[] sortedContinualArray=generateSortedAndDiscontinuousArray(1000);
        long end = System.nanoTime();

        builder.append("生成执行耗时:" + (end - begin) + "ns");
        //printData(sortedContinualArray);
        String result = toString(sortedContinualArray);
        builder.append(result);

        end = System.nanoTime();

        builder.append("执行耗时:" + (end - begin) + "ns");

        return builder.toString();
    }

    /**
     * 生成排序且不连续的整形数组
     * @param generateCount
     * @return
     */
    public static int[] generateSortedAndDiscontinuousArray(int generateCount) {
        if (generateCount <= 0)
            return new int[0];

        int[] targetArray = new int[generateCount];

        for (int index = 0; index < generateCount; index++) {
            targetArray[index] = index * 2 + index % 2;
        }
        return targetArray;
    }

    public static String toString(int[] arrays){
        if (arrays == null)
            return "null";
        int iMax = arrays.length - 1;
        if (iMax == -1)
            return "";

        StringBuffer b = new StringBuffer();
        for (int i = 0; ;i++) {
            b.append(arrays[i]);
            if (i == iMax)
                return b.toString();
            b.append(Sepertor);
        }
    }
}
