package thinking_in_java.chapter16;

import thinking_in_java.chapter15.Generator;

import java.util.Random;
import static thinking_in_java.chapter16.CountingGenerator.chars;

/**
 * Created by wangbin10 on 2019/1/29.
 */
public class RandomGenerator {
    private static Random r = new Random(47);

    public static class Boolean implements Generator<java.lang.Boolean> {

        @Override
        public java.lang.Boolean next() {
            return r.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {

        @Override
        public java.lang.Byte next() {
            return (byte) r.nextInt();
        }
    }


    public static class Character implements Generator<java.lang.Character> {
        @Override
        public java.lang.Character next() {
            return chars[r.nextInt(chars.length)];
        }
    }

    public static class String extends CountingGenerator.String {
        {
            gc = new CountingGenerator.Character();
        }

        public String() {
        }

        public String(int length) {
            super(length);
        }

    }

    public static class Short implements Generator<java.lang.Short> {

        @Override
        public java.lang.Short next() {
            return (short) r.nextInt();
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {

        @Override
        public java.lang.Integer next() {
            return r.nextInt();
        }
    }

    public static class Long implements Generator<java.lang.Long> {

        @Override
        public java.lang.Long next() {
            return r.nextLong();
        }
    }

    public static class Float implements Generator<java.lang.Float> {

        @Override
        public java.lang.Float next() {
            return r.nextFloat();
        }
    }

    public static class Double implements Generator<java.lang.Double> {

        @Override
        public java.lang.Double next() {
            return r.nextDouble();
        }
    }
}
