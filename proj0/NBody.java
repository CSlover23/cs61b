public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);

        int N = in.readInt(); // "new Planet[N]" BELOW WONT'T REPORT ERROR!
        // int N; //"new Planet[N]" BELOW REPORT ERROR that N is not initialized!

        double R = in.readDouble();
        Planet[] planets = new Planet[N];

        int i = 0;
        // while (!in.isEmpty()) {
        /*
         * THIS CODE IS WRONG BECAUSE fileName file has some
         * comments at the bottom
         */
        while (i < N) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            i += 1;
        }
        return planets;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("arguments is not enough!");
        }

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setCanvasSize(700, 500);
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg", 2 * radius, 2 * radius);
        // StdDraw.show();

        // planets[0].draw();
        /*
         * COMPILING THIS FILE WHILE NOT SAVING Planet.java(add
         * draw() method) causing error
         */
        for (Planet s : planets) {
            s.draw();
        }
        StdDraw.show();

        StdDraw.enableDoubleBuffering();
        double curTime = 0;
        while (curTime < T) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i += 1) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i += 1) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg", 2 * radius, 2 * radius);
            for (Planet s : planets) {
                s.draw();
            }
            StdDraw.show();
            StdDraw.pause(1);
            curTime += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}
