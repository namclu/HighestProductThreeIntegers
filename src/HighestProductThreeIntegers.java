public class HighestProductThreeIntegers {

    public static void main(String[] args) {
        int[] testArray = {1, 10, -5, 1, -100};

        System.out.println(getHighestProductThreeIntegers(testArray));
    }

    public static int getHighestProductThreeIntegers(int[] intArray) {

        if (intArray.length < 3) {
            throw new IllegalArgumentException("Requires an array w 3 at least indexes.");
        }

        int highestProductOf3 = intArray[0] * intArray[1] * intArray[2];
        int highestProductOf2 = intArray[0] * intArray[1];
        int highest = Math.max(intArray[0], intArray[1]);
        int lowestProductOf2 = intArray[0] * intArray[1];
        int lowest = Math.min(intArray[0], intArray[1]);

        // i < 5, current = null, hpo3 = -50, hpo2 = 10, h = 10, lpo2 = 10, l = 1
        // i = 2, current = -5, hpo3 = -50/-50/-50, hpo2 = 10/-50/-5, h = 10/-5, lpo2 = 10/-50/-5 l = 1/-5
        // i = 3, current = 1, hpo3 = -50/10/-50, hpo2 = 10/10/-5, h = 10/1, lpo2 = -50/10/-5, l = -5/1
        // i = 4, current = -100, hpo3 = 10/-500/5000, hpo2 = 10/-1000/500, h = 10/-100, lpo2 = -50/-1000/500, l -5/-100
        for (int i = 2; i < intArray.length; i++) {
            int current = intArray[i];

            // do we have the highest product of 3?
            highestProductOf3 = Math.max(highestProductOf3,
                    Math.max(highestProductOf2 * current, lowestProductOf2 * current));

            // do we have a new highest product of 2?
            highestProductOf2 = Math.max(highestProductOf2,
                    Math.max(current * highest, current * lowest));

            // do we have a new highest?
            highest = Math.max(highest, current);


            // do we have a new lowest product of 2?
            lowestProductOf2 = Math.min(lowestProductOf2,
                    Math.min(current * highest, current * lowest));

            // do we have a new lowest?
            lowest = Math.min(lowest, current);
        }
        return highestProductOf3;
    }
}
