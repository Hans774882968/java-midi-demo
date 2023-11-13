public interface MyNote {
    enum Major {
        A(57), A_UP(58), B(59), C(60), C_UP(61), D(62), D_UP(63), E(64), F(65), F_UP(66), G(67), G_UP(68);

        public final int value;

        Major(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    MyNote setPPQ(String ppq);

    MyNote setBPM(int bpm);

    MyNote setMajor(Major major);

    MyNote setLeftStart(boolean leftStart);

    MyNote setRightStart(boolean rightStart);
}
