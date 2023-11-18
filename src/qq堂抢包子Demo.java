import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class qq堂抢包子Demo {
    public static void main(String[] args)
            throws InvalidMidiDataException, MidiUnavailableException, InterruptedException {
        final int scale = 8;
        final int beat = scale * 4;
        final int channel = 6;
        final int volume = 100;
        final int length = beat * 4;

        Sequencer player = MidiSystem.getSequencer();
        Sequence sequence = new Sequence(Sequence.PPQ, scale * 4);
        player.setSequence(sequence);
        Track track = sequence.createTrack();

        MyNoteImpl myNoteImpl = new MyNoteImpl(MyNote.Major.C);

        qq堂抢包子right(track, channel, myNoteImpl, volume, beat, length);

        player.open();
        Thread.sleep(100);
        player.setTempoInBPM(140);
        player.start();
    }

    public static void qq堂抢包子right(
            Track track, int channel, MyNoteImpl myNoteImpl,
            int volume, int beat, int length) throws InvalidMidiDataException {
        int tick = 0;

        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(1), volume, tick, beat * 2, tick + length);

        // 3
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSi(0), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat * 2, tick + length);

        // 5
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(1), volume, tick, beat * 2, tick + length);

        // 7
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSi(0), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat * 5 / 2, tick + length);

        // 9
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat, tick + length);

        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);

        // 11
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat * 5 / 2, tick + length);

        // 13
        tick += addNote(track, channel, myNoteImpl.getLa(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(1), volume, tick, beat * 3 / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat * 3 / 2, tick + length);

        // 15
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFaUp(1), volume, tick, beat * 3 / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat * 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(2), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(2), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(2), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(2), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(2), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSi(1), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(1), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSi(0), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(0), volume, tick, beat / 7, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(0), volume, tick, beat / 7, tick + length);

        // 17
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSol(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getLa(1), volume, tick, beat * 2, tick + length);

        // 19
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getMi(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getFa(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getSi(0), volume, tick, beat / 2, tick + length);

        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat, tick + length);
        tick += addNote(track, channel, myNoteImpl.getRe(1), volume, tick, beat / 2, tick + length);
        tick += addNote(track, channel, myNoteImpl.getDo(1), volume, tick, beat * 5 / 2, tick + length);
    }

    public static int addNote(Track track, int channel, int note, int volume, int tick, int length, int endTick)
            throws InvalidMidiDataException {
        ShortMessage shortMessage = new ShortMessage(ShortMessage.NOTE_ON, channel, note, volume);
        MidiEvent midiEvent = new MidiEvent(shortMessage, tick);
        track.add(midiEvent);
        ShortMessage shortMessage2 = new ShortMessage(ShortMessage.NOTE_OFF, channel, note, volume);
        MidiEvent midiEvent2 = new MidiEvent(shortMessage2, endTick);
        track.add(midiEvent2);
        return length;
    }
}
