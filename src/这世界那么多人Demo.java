import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class 这世界那么多人Demo {
    public static void main(String[] args)
            throws InvalidMidiDataException, MidiUnavailableException, InterruptedException {
        final int scale = 8; // scale 随意，体现 beat 和 Sequence 2nd param resolution 的关系即可
        final int beat = scale * 4;
        final int channel = 6;
        final int volume = 100;
        final int length = beat * 4;

        Sequencer player = MidiSystem.getSequencer();
        Sequence sequence = new Sequence(Sequence.PPQ, scale * 4);
        player.setSequence(sequence);
        Track track = sequence.createTrack();

        MyNoteImpl myNoteImpl = new MyNoteImpl(MyNote.Major.B);

        这世界那么多人right(track, channel, myNoteImpl, volume, beat, length);

        player.open();
        Thread.sleep(100);
        player.setTempoInBPM(72);
        player.start();
    }

    public static void 这世界那么多人right(
            Track track, int channel, MyNoteImpl myNoteImpl,
            int volume, int beat, int length) throws InvalidMidiDataException {
        int tick = 0;

        tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(2), volume, tick, beat, tick + length);

        // 3
        tick += addNote(track, channel, myNoteImpl.getLa(1), volume, tick, beat * 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat, tick + length);

        // 5
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat * 2, tick + length);

        // 6
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat * 3 / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

        // 7 这世界有那么多
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);

        // 8 人 人群
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat * 2, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);

        // 9 里敞着一扇
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);

        // 10 门 我
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

        // 11 迷朦的眼睛里
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);

        // 12 长存 初见
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);

        // 13 你蓝色清
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);

        // 14 晨 这
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat * 2, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

        // 15 世界有那么多
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);

        // 16 人 多幸
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat * 2, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);

        // 17 运我有个我
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);

        // 18 们 这
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

        // 19 悠长命运中的
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);

        // 20 晨昏 常让
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat * 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);

        // 21 我望远方出
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat, tick + length);

        // 22 神
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat * 3, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat, tick + length);

        // 23 灰树叶飘转
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);

        // 24 在池塘
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat * 2, tick + length);

        // 25 看飞机轰的一声
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);

        // 26 去远乡 光阴
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);

        // 27 的长廊
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat * 2, tick + length);

        // 28 脚步声叫嚷 灯一
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);

        // 29 亮 无人的空
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);

        // 30 荡
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat * 3, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat, tick + length);

        // 31 晚风中闪过
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat, tick + length);

        // 32 几帧从前啊
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat * 2, tick + length);

        // 33 飞驰中旋转
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);

        // 34 已不见了吗
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat * 2, tick + length);

        // 35 远光中走来
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat, tick + length);

        // 36 你一身晴朗
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat * 2, tick + length);

        // 37 身旁那么多人
        tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);

        // 38 可世界不声不
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);

        // 39 响
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat * 2, tick + length);

        // 40
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat * 2, tick + length);

        // 43 (重复的省略，到结尾部分) 这
        tick += addNote(track, channel, 0, 0, tick, beat * 3, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat, tick + length);

        // 44 世界有那么多
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);

        // 45 人 活在
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat * 2, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);

        // 46 我飞扬的青
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);

        // 47 春 在
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

        // 48 泪水里浸湿过的
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);

        // 49 长吻 常让
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat * 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);

        // 50 我想啊想出
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat * 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);

        // 51 神
        tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat * 3, tick + length);
        tick += addNote(track, channel, 0, 0, tick, beat, tick + length);

        // 52 最后的伴奏找不到简谱，这个谱也不对，先注释了
        // tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        // tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
        // tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat, tick + length);
        // tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat, tick + length);
        // tick += addNote(track, channel, 0, 0, tick, beat, tick + length);
        // tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat * 2 / 3, tick + length);
        // tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat * 2 / 3, tick + length);
        // tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat * 2 / 3, tick + length);
        // tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
    }

    public static int addNote(Track track, int channel, int note, int volume, int tick, int length, int endTick)
            throws InvalidMidiDataException {
        // channel: instrument. different kinds of piano
        ShortMessage shortMessage = new ShortMessage(ShortMessage.NOTE_ON, channel, note, volume);
        MidiEvent midiEvent = new MidiEvent(shortMessage, tick);
        track.add(midiEvent);
        ShortMessage shortMessage2 = new ShortMessage(ShortMessage.NOTE_OFF, channel, note, volume);
        MidiEvent midiEvent2 = new MidiEvent(shortMessage2, endTick);
        track.add(midiEvent2);
        return length;
    }
}
