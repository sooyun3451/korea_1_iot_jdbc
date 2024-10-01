package korea_1_iot_jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import korea_1_iot_jdbc.dao.UserDAO;
import korea_1_iot_jdbc.entity.User;

public class UserManager {
	public void run() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		UserDAO userDao = new UserDAO();

		while (true) {
			System.out.println("1. 사용자 단건 조회");
			System.out.println("2. 사용자 전체 조회");
			System.out.println("3. 사용자 추가");
			System.out.println("4. 사용자 정보 수정");
			System.out.println("5. 사용자 삭제");
			System.out.print("메뉴 선택: ");

			String selectedMenu = scanner.nextLine();

			switch (selectedMenu) {
			case "1":
				viewUserById(scanner, userDao);
				break;
			}
		}

	}

	private void viewUserById(Scanner scanner, UserDAO userDao) throws SQLException {
		System.out.print("조회할 사용자 ID 입력: ");
		int id = Integer.parseInt(scanner.nextLine());

		User user = userDao.getUserById(id);

		if (user != null) {
			System.out.println("User ID: " + user.getId());
			System.out.println("User Name: " + user.getName());
			System.out.println("User Email: " + user.getEmail());
		} else {
			System.out.println("해당 ID의 사용자를 찾을 수 없습니다.");
		}
	}

}
