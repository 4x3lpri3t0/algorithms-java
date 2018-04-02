/*
#Drone Flight Planner

You are planning the amount of fuel need to complete a drone flight.

To fly higher, the drone burns 1 liter of fuel per feet.

However, flying lower charges the drone with the amount of energy equivalent to 1 liter of fuel for every feet.

Flying sideways takes no energy (only flying up and down takes/charges energy).

Given an array of 3D coordinates named route, find the minimal amount of fuel the drone would need to fly through this route.

Explain and code the most efficient solution possible, with the minimal number of actions and variables.

Example:

    Completing the route
    [ {x: 0, y: 2, z:10},
      {x: 3, y: 5, z: 0},
      {x: 9, y:20, z: 6},
      {x:10, y:12, z:15},
      {x:10, y:10, z: 8}  ]
  requires a minimum of 5 liters of fuel.
*/

public class Drone_Flight_Planner {
    private class Point {
        int x;
        int y;
        int z;

        public Point(int i, int j, int k) {
            x = i;
            y = j;
            z = k;
        }
    }

    public static int getStartingFuelBetter(Point[] route) {
        if (route == null || route.length == 0) {
            return 0;
        }

        int highestPoint = route[0].z;
        for (int i = 1; i < route.length; i++) {
            highestPoint = Math.max(highestPoint, route[i].z);
        }

        return highestPoint - route[0].z;
    }

    public static int getStartingFuel(Point[] route) {
        if (route == null || route.length <= 1) {
            return 0;
        }

        int startingFuel = 0;
        int currentFuel = 0;
        for (int i = 1; i < route.length; i++) {
            currentFuel += route[i - 1].z - route[i].z;
            if (currentFuel < 0) {
                startingFuel -= currentFuel;
                currentFuel = 0;
            }
        }

        return startingFuel;
    }

    public void main(String[] args) {
        Point[] route = new Point[5];
        route[0] = new Point(0, 2, 10);
        route[1] = new Point(3, 5, 0);
        route[2] = new Point(9, 20, 6);
        route[3] = new Point(10, 12, 15);
        route[4] = new Point(10, 10, 8);

        System.out.println(getStartingFuel(route));
        System.out.println(getStartingFuelBetter(route));
    }
}