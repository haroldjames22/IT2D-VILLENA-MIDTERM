
package schedule;

import java.util.Scanner;


public class Schedule {

    // Method to add a schedule record
    public void addSchedule() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Day of Week: ");
        String dayOfWeek = sc.next();
        System.out.print("Start Time (HH:MM): ");
        String startTime = sc.next();
        System.out.print("End Time (HH:MM): ");
        String endTime = sc.next();
        
        String sql = "INSERT INTO tbl_schedule (day_of_week, start_time, end_time) VALUES (?, ?, ?)";
        conf.addRecord(sql, dayOfWeek, startTime, endTime);
    }

    // Method to view all schedule records
    private void viewSchedule() {
        String query = "SELECT * FROM tbl_schedule";
        String[] scheduleHeaders = {"ID", "DAY_OF_WEEK", "START_TIME", "END_TIME"};
        String[] scheduleColumns = {"schedule_id", "day_of_week", "start_time", "end_time"};
        config conf = new config();
        conf.viewRecords(query, scheduleHeaders, scheduleColumns);
    }

    // Method to update a schedule record
    private void updateSchedule() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Schedule ID:");
        int scheduleId = sc.nextInt();
        System.out.println("Enter the new day of week:");
        String dayOfWeek = sc.next();
        System.out.println("Enter the new start time (HH:MM):");
        String startTime = sc.next();
        System.out.println("Enter the new end time (HH:MM):");
        String endTime = sc.next();
        
        String query = "UPDATE tbl_schedule SET day_of_week = ?, start_time = ?, end_time = ? WHERE schedule_id = ?";
        config conf = new config();
        conf.updateRecord(query, dayOfWeek, startTime, endTime, scheduleId);
    }

    // Method to delete a schedule record
    private void deleteSchedule() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Schedule ID to Delete: ");
        int scheduleId = sc.nextInt();
        String query = "DELETE FROM tbl_schedule WHERE schedule_id = ?";
        config conf = new config();
        conf.deleteRecord(query, scheduleId);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;
        do {
            System.out.println("1. Add Schedule");
            System.out.println("2. View Schedule");
            System.out.println("3. Update Schedule");
            System.out.println("4. Delete Schedule");
            System.out.println("Enter Action: ");
            int action = sc.nextInt();
            Schedule demo = new Schedule();
            switch (action) {
                case 1:
                    demo.addSchedule();
                    break;
                case 2:
                    demo.viewSchedule();
                    break;
                case 3:
                    demo.updateSchedule();
                    break;
                case 4:
                    demo.deleteSchedule();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            System.out.println("Continue (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));
        System.out.println("Thank you, See you soon!");
    }
}