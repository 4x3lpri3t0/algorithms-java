class _02_product_of_other_numbers {
    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {
        if (intArray.length < 2) {
            throw new IllegalArgumentException("Required at least 2 numbers");
        }

        // Array with the length of the input to hold our products
        int[] productsExceptAtIdx = new int[intArray.length];

        // Product of all the integers before integer,
        // storing the total product so far each time
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsExceptAtIdx[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // Find the product of integers after it.
        // Since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsExceptAtIdx[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

        return productsExceptAtIdx;
    }
}

// O(n) time
// O(n) space