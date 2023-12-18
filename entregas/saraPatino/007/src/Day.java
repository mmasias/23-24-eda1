package src;

public class Day {
    public Day(){}

    public static TreeNode getDayNodeOrCreateNew(List<TreeNode> dias, int selectedDay) {
        for (Object day : dias.listData()) {
            TreeNode existingDay = (TreeNode) day;
            if (existingDay.key.equals("Dia " + selectedDay)) {
                return existingDay;
            }
        }

        TreeNode newDay = new TreeNode("Dia " + selectedDay);
        dias.insert(newDay, -1);
        return newDay;
    }
}
