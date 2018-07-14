class _21_Find_Unique_Int_Among_Duplicates {
    public static int findUniqueDeliveryId(int[] deliveryIds) {
        int uniqueDeliveryId = 0;

        for (int deliveryId : deliveryIds) {
            uniqueDeliveryId ^= deliveryId;
        }

        return uniqueDeliveryId;
    }
}
// O(n) time
// O(1) space