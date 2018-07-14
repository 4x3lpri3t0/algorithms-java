import java.util.HashSet;
import java.util.Set;

// The trick is to use a hash set to access
// our movies by length, in O(1) time
class _14_Inflight_Entertainment {
    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {
        // Movie lengths we've seen so far
        Set<Integer> movieLengthsSeen = new HashSet<>();

        for (int movie : movieLengths) {
            int complementLength = flightLength - movie;
            if (movieLengthsSeen.contains(complementLength)) {
                return true;
            }

            movieLengthsSeen.add(movie);
        }

        return false;
    }
}
// O(n) time
// O(n) space