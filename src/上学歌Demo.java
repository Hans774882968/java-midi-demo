import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class 上学歌Demo {
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

        MyNoteImpl myNoteIMPL = new MyNoteImpl(MyNote.Major.C);

        上学歌left(track, channel, myNoteIMPL, volume, beat, length);
        上学歌right(track, channel, myNoteIMPL, volume, beat, length);

        player.open();
        Thread.sleep(100);
        player.setTempoInBPM(112);
        player.start();
    }

    public static void 上学歌left(
            Track track, int channel, MyNoteImpl myNoteImpl,
            int volume, int beat, int length) throws InvalidMidiDataException {
        int tick = 0;
        for (int i = 0; i < 2; i++) {
            // 太阳当空
            tick += addNote(track, channel, myNoteImpl.getDo(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getMi(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

            // 照
            tick += addNote(track, channel, myNoteImpl.getDo(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getMi(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

            // 花儿对我
            tick += addNote(track, channel, myNoteImpl.getDo(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getFa(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);

            // 笑
            tick += addNote(track, channel, myNoteImpl.getDo(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getMi(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

            // 小鸟说
            tick += addNote(track, channel, myNoteImpl.getDo(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getFa(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getLa(-1), volume, tick, beat / 2, tick + length);

            // 早早早
            tick += addNote(track, channel, myNoteImpl.getDo(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getMi(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

            // 你为什么
            tick += addNote(track, channel, myNoteImpl.getDo(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getMi(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);

            // 背上小书
            tick += addNote(track, channel, myNoteImpl.getSol(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getRe(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSi(-1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getRe(-1), volume, tick, beat / 2, tick + length);

            // 包
            tick += addNote(track, channel, myNoteImpl.getDo(-1), volume, tick, beat * 3 / 2, tick + length);
            tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);
        }
    }

    public static void 上学歌right(
            Track track, int channel, MyNoteImpl myNoteImpl,
            int volume, int beat, int length) throws InvalidMidiDataException {
        int tick = 0;
        for (int i = 0; i < 2; i++) {
            // 太阳当空
            tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);

            // 照
            tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat * 3 / 2, tick + length);
            tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);

            // 花儿对我
            tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);

            // 笑
            tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat * 3 / 2, tick + length);
            tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);

            // 小鸟说
            tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);

            // 早早早
            tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat, tick + length);

            // 你为什么
            tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);

            // 背上小书
            tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getRe(0), volume, tick, beat / 2, tick + length);
            tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);

            // 包
            tick += addNote(track, channel, myNoteImpl.getDo(0), volume, tick, beat * 3 / 2, tick + length);
            tick += addNote(track, channel, 0, 0, tick, beat / 2, tick + length);
        }
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
