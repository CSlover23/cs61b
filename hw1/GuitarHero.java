public class GuitarHero {
    private static final double CONCERT = 440.0;
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final int NOTENUM = 37;

    private static double ithConcert(int i) {
        return CONCERT * Math.pow(2, (i - 24) / 12.0);
    }

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        synthesizer.GuitarString[] guitarHero = new synthesizer.GuitarString[NOTENUM];
        for (int i = 0; i < NOTENUM; i += 1) {
            guitarHero[i] = new synthesizer.GuitarString(ithConcert(i));
        }

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                if (index < 0) {
                    System.out.println("Wrong input! Please try again!");
                } else {
                    guitarHero[index].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < NOTENUM; i += 1) {
                sample += guitarHero[i].sample();
            }
            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (synthesizer.GuitarString s: guitarHero) {
                s.tic();
            }
        }
    }

}
