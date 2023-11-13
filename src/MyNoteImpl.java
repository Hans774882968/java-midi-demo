public class MyNoteImpl implements MyNote {
    private Major major;
    public String ppq;
    public int bpm;
    public boolean leftStart;
    public boolean rightStart;

    public MyNoteImpl(Major major) {
        this.major = major;
    }

    public Major getMajor() {
        return this.major;
    }

    public String getPpq() {
        return this.ppq;
    }

    public int getBpm() {
        return this.bpm;
    }

    public boolean isLeftStart() {
        return this.leftStart;
    }

    public boolean isRightStart() {
        return this.rightStart;
    }

    // area 基于中央区升降几个区域
    public int getDo(int area) {
        return major.value + 12 * area;
    }

    public int getDoUp(int area) {
        return major.value + 1 + 12 * area;
    }

    public int getRe(int area) {
        return major.value + 2 + 12 * area;
    }

    public int getReUp(int area) {
        return major.value + 3 + 12 * area;
    }

    public int getMi(int area) {
        return major.value + 4 + 12 * area;
    }

    public int getFa(int area) {
        return major.value + 5 + 12 * area;
    }

    public int getFaUp(int area) {
        return major.value + 6 + 12 * area;
    }

    public int getSol(int area) {
        return major.value + 7 + 12 * area;
    }

    public int getSolUp(int area) {
        return major.value + 8 + 12 * area;
    }

    public int getLa(int area) {
        return major.value + 9 + 12 * area;
    }

    public int getLaUp(int area) {
        return major.value + 10 + 12 * area;
    }

    public int getSi(int area) {
        return major.value + 11 + 12 * area;
    }

    @Override
    public MyNote setPPQ(String ppq) {
        this.ppq = ppq;
        return this;
    }

    @Override
    public MyNote setBPM(int bpm) {
        this.bpm = bpm;
        return this;
    }

    @Override
    public MyNote setMajor(Major major) {
        this.major = major;
        return this;
    }

    @Override
    public MyNote setLeftStart(boolean leftStart) {
        this.leftStart = leftStart;
        return this;
    }

    @Override
    public MyNote setRightStart(boolean rightStart) {
        this.rightStart = rightStart;
        return this;
    }
}
