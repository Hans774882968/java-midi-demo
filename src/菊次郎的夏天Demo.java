import java.util.Arrays;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

class AddNoteParams {
    String desc;
    int note;
    int volume;
    int length;
    int endTickDelta;

    public AddNoteParams(int note, int volume, int length, int endTickDelta) {
        this("", note, volume, length, endTickDelta);
    }

    public AddNoteParams(String desc, int note, int volume, int length, int endTickDelta) {
        this.desc = desc;
        this.note = note;
        this.volume = volume;
        this.length = length;
        this.endTickDelta = endTickDelta;
    }
}

public class 菊次郎的夏天Demo {
    static final int[] playSequence = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 4, 5, 6, 7, 8, 9, 10, 11, 12
    };

    public static void main(String[] args)
            throws InvalidMidiDataException, MidiUnavailableException, InterruptedException {
        final int scale = 8;
        final int beat = scale * 4;
        final int channel = 6;
        final int volume = 100;
        final int length = beat * 4;

        final boolean playLeft = true;
        final boolean playRight = true;
        final int startPlayIndex = 0;
        final int endPlayIndex = Integer.MAX_VALUE;

        Sequencer player = MidiSystem.getSequencer();
        Sequence sequence = new Sequence(Sequence.PPQ, scale * 4);
        player.setSequence(sequence);
        Track track = sequence.createTrack();

        MyNoteImpl myNoteIMPL = new MyNoteImpl(MyNote.Major.D);

        if (playLeft) {
            菊次郎的夏天left(
                    track, channel, myNoteIMPL, volume, beat,
                    length, startPlayIndex, endPlayIndex);
        }
        if (playRight) {
            菊次郎的夏天right(
                    track, channel, myNoteIMPL, volume, beat,
                    length, startPlayIndex, endPlayIndex);
            菊次郎的夏天right2(
                    track, channel, myNoteIMPL, volume, beat,
                    length, startPlayIndex, endPlayIndex);
            菊次郎的夏天right3(
                    track, channel, myNoteIMPL, volume, beat,
                    length, startPlayIndex, endPlayIndex);
        }

        player.open();
        Thread.sleep(100);
        player.setTempoInBPM(90);
        player.start();
    }

    public static void 菊次郎的夏天left(
            Track track, int channel, MyNoteImpl myNoteImpl, int volume,
            int beat, int length, int startPlayIndex, int endPlayIndex) throws InvalidMidiDataException {
        AddNoteParams[][] bars = {
                {
                        new AddNoteParams(myNoteImpl.getLa(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getMi(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getLa(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getMi(-1), volume, beat / 2, beat / 8),

                        new AddNoteParams(myNoteImpl.getFa(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getFa(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, beat / 8),
                },
                {
                        new AddNoteParams(myNoteImpl.getSol(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, beat / 8),

                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getDo(0), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                },
                {
                        new AddNoteParams("3 5", myNoteImpl.getLa(-2), volume, beat / 2, length),
                        new AddNoteParams("3 5", myNoteImpl.getMi(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams("3 5", myNoteImpl.getLa(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams("3 5", myNoteImpl.getMi(-1), volume, beat / 2, beat / 8),

                        new AddNoteParams(myNoteImpl.getFa(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getFa(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, beat / 8),
                },
                {
                        new AddNoteParams(myNoteImpl.getSol(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, beat / 8),

                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getDo(0), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                },
                {
                        new AddNoteParams("5 9", myNoteImpl.getLa(-2), volume, beat / 2, length),
                        new AddNoteParams("5 9", myNoteImpl.getMi(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams("5 9", myNoteImpl.getLa(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams("5 9", myNoteImpl.getMi(-1), volume, beat / 2, beat / 8),

                        new AddNoteParams(myNoteImpl.getFa(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getFa(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, beat / 8),
                },
                {
                        new AddNoteParams(myNoteImpl.getSol(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, beat / 8),

                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getDo(0), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                },
                {
                        new AddNoteParams("7 13", myNoteImpl.getLa(-2), volume, beat / 2, length),
                        new AddNoteParams("7 13", myNoteImpl.getMi(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams("7 13", myNoteImpl.getLa(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams("7 13", myNoteImpl.getMi(-1), volume, beat / 2, beat / 8),

                        new AddNoteParams(myNoteImpl.getFa(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getFa(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, beat / 8),
                },
                {
                        new AddNoteParams(myNoteImpl.getSol(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, beat / 8),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, beat / 8),

                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(0), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, length),
                },
                {
                        new AddNoteParams("9 17", myNoteImpl.getSol(-2), volume, beat / 2, length),
                        new AddNoteParams("9 17", myNoteImpl.getRe(-1), volume, beat / 2, length),
                        new AddNoteParams("9 17", myNoteImpl.getSol(-1), volume, beat / 2, length),
                        new AddNoteParams("9 17", myNoteImpl.getRe(-1), volume, beat / 2, length),

                        new AddNoteParams(myNoteImpl.getFa(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getFa(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, length),
                },
                {
                        new AddNoteParams(myNoteImpl.getMi(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSi(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getMi(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSi(-2), volume, beat / 2, length),

                        new AddNoteParams(myNoteImpl.getLa(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getMi(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getLa(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getMi(-1), volume, beat / 2, length),
                },
                {
                        new AddNoteParams("11 21", myNoteImpl.getRe(-2), volume, beat / 2, length),
                        new AddNoteParams("11 21", myNoteImpl.getLa(-2), volume, beat / 2, length),
                        new AddNoteParams("11 21", myNoteImpl.getRe(-1), volume, beat / 2, length),
                        new AddNoteParams("11 21", myNoteImpl.getLa(-2), volume, beat / 2, length),

                        new AddNoteParams(myNoteImpl.getFa(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getFa(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(-1), volume, beat / 2, length),
                },
                {
                        new AddNoteParams(myNoteImpl.getSol(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, length),

                        new AddNoteParams(myNoteImpl.getSol(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getRe(-1), volume, beat / 2, length),
                },
                {
                        new AddNoteParams("13 25", myNoteImpl.getMi(-2), volume, beat / 2, length),
                        new AddNoteParams("13 25", myNoteImpl.getSi(-2), volume, beat / 2, length),
                        new AddNoteParams("13 25", myNoteImpl.getMi(-1), volume, beat / 2, length),
                        new AddNoteParams("13 25", myNoteImpl.getSi(-2), volume, beat / 2, length),

                        new AddNoteParams(myNoteImpl.getLa(-2), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getMi(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getLa(-1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getMi(-1), volume, beat / 2, length),
                },
        };
        addNotesByBars(track, channel, bars, startPlayIndex, endPlayIndex);
    }

    private static void 菊次郎的夏天right(
            Track track, int channel, MyNoteImpl myNoteImpl, int volume,
            int beat, int length, int startPlayIndex, int endPlayIndex) throws InvalidMidiDataException {
        AddNoteParams[][] bars = {
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("3", 0, 0, beat, length),
                        new AddNoteParams("3", 0, 0, beat, length),
                        new AddNoteParams("3", 0, 0, beat, length),
                        new AddNoteParams("3", 0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),

                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getMi(1), volume, beat / 4, beat / 4 / 4),
                },
                {
                        new AddNoteParams("5-1", myNoteImpl.getRe(1), volume, beat / 2, beat / 2 / 4),
                        new AddNoteParams("5-1", myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("5-1", myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("5-1", myNoteImpl.getDo(1), 0, beat, beat),

                        new AddNoteParams("5-2", 0, 0, beat, length),
                        new AddNoteParams("5-2", myNoteImpl.getSol(0), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("5-2", myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("5-2", myNoteImpl.getRe(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("5-2", myNoteImpl.getMi(1), volume, beat / 4, beat / 4 / 4),
                },
                {
                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat / 2, beat / 2 / 4),
                        new AddNoteParams(myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getRe(1), 0, beat / 2, beat / 2 / 4),
                        new AddNoteParams(myNoteImpl.getMi(1), volume, beat / 2, beat / 2 / 4),
                        new AddNoteParams(myNoteImpl.getMi(1), volume, beat, beat),

                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getMi(1), volume, beat / 4, beat / 4 / 4),
                },
                {
                        new AddNoteParams("7-1", myNoteImpl.getRe(1), volume, beat / 2, beat / 2 / 4),
                        new AddNoteParams("7-1", myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("7-1", myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("7-1", myNoteImpl.getDo(1), 0, beat, beat),

                        new AddNoteParams("7-2", 0, 0, beat, length),
                        new AddNoteParams("7-2", myNoteImpl.getSol(0), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("7-2", myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("7-2", myNoteImpl.getRe(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams("7-2", myNoteImpl.getMi(1), volume, beat / 4, beat / 4 / 4),
                },
                {
                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat / 2, beat / 2 / 4),
                        new AddNoteParams(myNoteImpl.getDo(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat / 4, beat / 4 / 4),
                        new AddNoteParams(myNoteImpl.getRe(1), 0, beat / 2, beat / 2 / 4),
                        new AddNoteParams(myNoteImpl.getSol(1), volume, beat / 2, beat / 2 / 4),
                        new AddNoteParams(myNoteImpl.getMi(1), volume, beat, length),
                        new AddNoteParams(myNoteImpl.getMi(0), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getFa(0), volume, beat / 2, length),
                },
                {
                        new AddNoteParams("9-1", myNoteImpl.getSol(0), volume, beat / 2, length),
                        new AddNoteParams("9-1", myNoteImpl.getSol(0), volume, beat / 4, length),
                        new AddNoteParams("9-1", myNoteImpl.getSol(0), volume, beat / 4, length),
                        new AddNoteParams("9-1", myNoteImpl.getSol(0), 0, beat / 2, length),
                        new AddNoteParams("9-1", myNoteImpl.getSol(0), volume, beat / 2, length),

                        new AddNoteParams("9-2", myNoteImpl.getSol(0), volume, beat / 2, length),
                        new AddNoteParams("9-2", myNoteImpl.getMi(1), volume, beat / 4, length),
                        new AddNoteParams("9-2", myNoteImpl.getLa(0), volume, beat / 4, length),
                        new AddNoteParams("9-2", myNoteImpl.getLa(0), 0, beat / 2, length),
                        new AddNoteParams("9-2", myNoteImpl.getMi(1), volume, beat / 4, length),
                        new AddNoteParams("9-2", myNoteImpl.getFa(1), volume, beat / 4, length),
                },
                {
                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getSol(0), 0, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 2, length),

                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getMi(1), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getLa(0), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getLa(0), 0, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getLa(0), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getSi(0), volume, beat / 4, length),
                },
                {
                        new AddNoteParams("11-1", myNoteImpl.getFaUp(0), volume, beat / 2, length),
                        new AddNoteParams("11-1", myNoteImpl.getFa(0), volume, beat / 4, length),
                        new AddNoteParams("11-1", myNoteImpl.getFa(0), volume, beat / 4, length),
                        new AddNoteParams("11-1", myNoteImpl.getFa(0), 0, beat / 2, length),
                        new AddNoteParams("11-1", myNoteImpl.getFa(0), volume, beat / 2, length),

                        new AddNoteParams("11-2", myNoteImpl.getLa(0), volume, beat / 2, length),
                        new AddNoteParams("11-2", myNoteImpl.getLa(1), volume, beat / 2, length),
                        new AddNoteParams("11-2", myNoteImpl.getRe(1), volume, beat / 4, length),
                        new AddNoteParams("11-2", myNoteImpl.getMi(1), volume, beat / 4, length),
                        new AddNoteParams("11-2", myNoteImpl.getRe(1), volume, beat / 4, length),
                        new AddNoteParams("11-2", myNoteImpl.getDo(1), volume, beat / 4, length),
                },
                {
                        new AddNoteParams(myNoteImpl.getFa(0), volume, beat, length),

                        new AddNoteParams(myNoteImpl.getFa(0), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getRe(0), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getRe(0), volume, beat / 4, length),

                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSi(0), volume, beat / 2, length),

                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getDo(1), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getMi(1), volume, beat / 4, length),
                },
                {
                        new AddNoteParams("13-1", myNoteImpl.getSol(0), volume, beat / 2, length),
                        new AddNoteParams("13-1", myNoteImpl.getSol(0), volume, beat / 4, length),
                        new AddNoteParams("13-1", myNoteImpl.getSol(0), volume, beat / 4, length),
                        new AddNoteParams("13-1", myNoteImpl.getSol(0), 0, beat / 2, length),
                        new AddNoteParams("13-1", myNoteImpl.getSol(0), volume, beat / 2, length),

                        new AddNoteParams("13-2", myNoteImpl.getSol(0), volume, beat / 2, length),
                        new AddNoteParams("13-2", myNoteImpl.getMi(1), volume, beat / 4, length),
                        new AddNoteParams("13-2", myNoteImpl.getLa(0), volume, beat / 4, length),
                        new AddNoteParams("13-2", myNoteImpl.getLa(0), 0, beat / 2, length),
                        new AddNoteParams("13-2", myNoteImpl.getDo(1), volume, beat / 4, length),
                        new AddNoteParams("13-2", myNoteImpl.getRe(1), volume, beat / 4, length),
                },
        };
        addNotesByBars(track, channel, bars, startPlayIndex, endPlayIndex);
    }

    private static void 菊次郎的夏天right2(
            Track track, int channel, MyNoteImpl myNoteImpl, int volume,
            int beat, int length, int startPlayIndex, int endPlayIndex) throws InvalidMidiDataException {
        AddNoteParams[][] bars = {
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("3", 0, 0, beat, length),
                        new AddNoteParams("3", 0, 0, beat, length),
                        new AddNoteParams("3", 0, 0, beat, length),
                        new AddNoteParams("3", 0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("5", 0, 0, beat, length),
                        new AddNoteParams("5", 0, 0, beat, length),
                        new AddNoteParams("5", 0, 0, beat, length),
                        new AddNoteParams("5", 0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("7", 0, 0, beat, length),
                        new AddNoteParams("7", 0, 0, beat, length),
                        new AddNoteParams("7", 0, 0, beat, length),
                        new AddNoteParams("7", 0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(myNoteImpl.getSol(0), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getLa(0), volume, beat / 2, length),
                },
                {
                        new AddNoteParams("9-1", myNoteImpl.getSi(0), volume, beat / 2, length),
                        new AddNoteParams("9-1", myNoteImpl.getSi(0), volume, beat / 4, length),
                        new AddNoteParams("9-1", myNoteImpl.getSi(0), volume, beat / 4, length),
                        new AddNoteParams("9-1", myNoteImpl.getSi(0), 0, beat / 2, length),
                        new AddNoteParams("9-1", myNoteImpl.getSi(0), volume, beat / 2, length),

                        new AddNoteParams("9-2", myNoteImpl.getDo(1), volume, beat / 2, length),
                        new AddNoteParams("9-2", myNoteImpl.getDo(1), volume, beat / 2, length),
                        new AddNoteParams("9-2", myNoteImpl.getDo(1), 0, beat, length),
                },
                {
                        new AddNoteParams(myNoteImpl.getSi(0), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSi(0), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getSi(0), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getSi(0), 0, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSi(0), volume, beat / 2, length),

                        new AddNoteParams(myNoteImpl.getDo(1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(1), 0, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getDo(1), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat / 4, length),
                },
                {
                        new AddNoteParams("11-1", myNoteImpl.getDo(1), volume, beat / 2, length),
                        new AddNoteParams("11-1", myNoteImpl.getDo(1), volume, beat / 4, length),
                        new AddNoteParams("11-1", myNoteImpl.getDo(1), volume, beat / 4, length),
                        new AddNoteParams("11-1", myNoteImpl.getDo(1), 0, beat / 2, length),
                        new AddNoteParams("11-1", myNoteImpl.getDo(1), volume, beat / 2, length),

                        new AddNoteParams("11-2", myNoteImpl.getDo(1), volume, beat, length),
                        new AddNoteParams("11-2", myNoteImpl.getLa(1), volume, beat, length),
                },
                {
                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat, length),

                        new AddNoteParams(myNoteImpl.getLa(0), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getLa(0), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getLa(0), volume, beat / 4, length),

                        new AddNoteParams(myNoteImpl.getSi(0), volume, beat, length),

                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("13-1", myNoteImpl.getSi(0), volume, beat / 2, length),
                        new AddNoteParams("13-1", myNoteImpl.getSi(0), volume, beat / 4, length),
                        new AddNoteParams("13-1", myNoteImpl.getSi(0), volume, beat / 4, length),
                        new AddNoteParams("13-1", myNoteImpl.getSi(0), 0, beat / 2, length),
                        new AddNoteParams("13-1", myNoteImpl.getSi(0), volume, beat / 2, length),

                        new AddNoteParams("13-2", myNoteImpl.getDo(1), volume, beat / 2, length),
                        new AddNoteParams("13-2", myNoteImpl.getDo(1), volume, beat / 2, length),
                        new AddNoteParams("13-2", myNoteImpl.getDo(1), 0, beat, length),
                },
        };
        addNotesByBars(track, channel, bars, startPlayIndex, endPlayIndex);
    }

    private static void 菊次郎的夏天right3(
            Track track, int channel, MyNoteImpl myNoteImpl, int volume,
            int beat, int length, int startPlayIndex, int endPlayIndex) throws InvalidMidiDataException {
        AddNoteParams[][] bars = {
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("3", 0, 0, beat, length),
                        new AddNoteParams("3", 0, 0, beat, length),
                        new AddNoteParams("3", 0, 0, beat, length),
                        new AddNoteParams("3", 0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("5", 0, 0, beat, length),
                        new AddNoteParams("5", 0, 0, beat, length),
                        new AddNoteParams("5", 0, 0, beat, length),
                        new AddNoteParams("5", 0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("7", 0, 0, beat, length),
                        new AddNoteParams("7", 0, 0, beat, length),
                        new AddNoteParams("7", 0, 0, beat, length),
                        new AddNoteParams("7", 0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                        new AddNoteParams(myNoteImpl.getMi(1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getFa(1), volume, beat / 2, length),
                },
                {
                        new AddNoteParams("9-1", myNoteImpl.getSol(1), volume, beat / 2, length),
                        new AddNoteParams("9-1", myNoteImpl.getSol(1), volume, beat / 4, length),
                        new AddNoteParams("9-1", myNoteImpl.getSol(1), volume, beat / 4, length),
                        new AddNoteParams("9-1", myNoteImpl.getSol(1), 0, beat / 2, length),
                        new AddNoteParams("9-1", myNoteImpl.getSol(1), volume, beat / 2, length),

                        new AddNoteParams("9-2", myNoteImpl.getSol(1), volume, beat, length),
                        new AddNoteParams("9-2", 0, 0, beat, length),
                },
                {
                        new AddNoteParams(myNoteImpl.getSol(1), volume, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(1), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getSol(1), volume, beat / 4, length),
                        new AddNoteParams(myNoteImpl.getSol(1), 0, beat / 2, length),
                        new AddNoteParams(myNoteImpl.getSol(1), volume, beat / 2, length),

                        new AddNoteParams(myNoteImpl.getSol(1), volume, beat, length),
                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("11-1", myNoteImpl.getMi(1), volume, beat / 2, length),
                        new AddNoteParams("11-1", myNoteImpl.getMi(1), volume, beat / 4, length),
                        new AddNoteParams("11-1", myNoteImpl.getMi(1), volume, beat / 4, length),
                        new AddNoteParams("11-1", myNoteImpl.getMi(1), 0, beat / 2, length),
                        new AddNoteParams("11-1", myNoteImpl.getMi(1), volume, beat / 2, length),

                        new AddNoteParams("11-2", myNoteImpl.getMi(1), volume, beat, length),
                        new AddNoteParams("11-2", 0, 0, beat, length),
                },
                {
                        new AddNoteParams(0, 0, beat, length),

                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat, length),

                        new AddNoteParams(myNoteImpl.getRe(1), volume, beat, length),

                        new AddNoteParams(0, 0, beat, length),
                },
                {
                        new AddNoteParams("13-1", myNoteImpl.getSol(1), volume, beat / 2, length),
                        new AddNoteParams("13-1", myNoteImpl.getSol(1), volume, beat / 4, length),
                        new AddNoteParams("13-1", myNoteImpl.getSol(1), volume, beat / 4, length),
                        new AddNoteParams("13-1", myNoteImpl.getSol(1), 0, beat / 2, length),
                        new AddNoteParams("13-1", myNoteImpl.getSol(1), volume, beat / 2, length),

                        new AddNoteParams("13-2", myNoteImpl.getSol(1), volume, beat, length),
                        new AddNoteParams("13-2", 0, 0, beat, length),
                },
        };
        addNotesByBars(track, channel, bars, startPlayIndex, endPlayIndex);
    }

    public static void addNotesByBars(
            Track track, int channel, AddNoteParams[][] bars,
            int startPlayIndex, int endPlayIndex)
            throws InvalidMidiDataException {
        startPlayIndex = Math.min(bars.length, Math.max(startPlayIndex, 0));
        endPlayIndex = Math.min(bars.length, Math.max(startPlayIndex, endPlayIndex));
        AddNoteParams[][] playBars = Arrays.copyOfRange(bars, startPlayIndex, endPlayIndex);
        int tick = 0;
        // 只有入参为完整播放时才执行反复演奏
        if (bars.length == playBars.length) {
            for (int idx : playSequence) {
                for (AddNoteParams addNoteParams : bars[idx]) {
                    tick += addNote(
                            track, channel, addNoteParams.note, addNoteParams.volume, tick,
                            addNoteParams.length, tick + addNoteParams.endTickDelta);
                }
            }
        } else {
            for (AddNoteParams[] bar : playBars) {
                for (AddNoteParams addNoteParams : bar) {
                    tick += addNote(
                            track, channel, addNoteParams.note, addNoteParams.volume, tick,
                            addNoteParams.length, tick + addNoteParams.endTickDelta);
                }
            }
        }
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
