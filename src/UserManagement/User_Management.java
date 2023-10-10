package UserManagement;
	
			import java.io.BufferedReader;
			import java.io.BufferedWriter;
			import java.io.File;
			import java.io.FileReader;
			import java.io.FileWriter;
			import java.io.IOException;
			import java.util.ArrayList;
			import java.util.Iterator;
			import java.util.Scanner;

			public class User_Management{
				
				static ArrayList<User> AL = new ArrayList();
				static {
					try {
						MemoryReader();
					} catch (IOException e) {
					
						e.printStackTrace();
					}
				}

				public static void User_Mangement() throws IOException {
					Scanner S = new Scanner(System.in);
					boolean CanIkeepRunningtheprogram = true;
					while (CanIkeepRunningtheprogram) {
						System.out.println("....Welcome to UserMangement....");
						System.out.println("1.Add User");
						System.out.println("2.Edit User");
						System.out.println("3.Delete User");
						System.out.println("4.Search User");
						System.out.println("5.Exit\n");

						int OptionselectbyUser = S.nextInt();
						if (OptionselectbyUser == UserOptions.ADD_USER) {
							AddUser();
						} else if (OptionselectbyUser == UserOptions.EDIT_USER) {
							S.nextLine();
							String EU = S.nextLine();
							EditUser(EU);
						} else if (OptionselectbyUser == UserOptions.DELETE_USER) {
							S.nextLine();
							String DU = S.nextLine();
							DeleteUser(DU);
						} else if (OptionselectbyUser == UserOptions.SEARCH_USER) {
							S.nextLine();
							String SU = S.nextLine();
							SearchUser(SU);
						} else if (OptionselectbyUser == UserOptions.QUIT) {
							File F = new File("C:\\Users\\pandi\\eclipse-workspace\\ShopeManagement\\src\\UserManagement\\User.txt");

							FileWriter FW = new FileWriter(F, false);

							BufferedWriter BW = new BufferedWriter(FW);

							String Line;
							for (User U : AL) {
								BW.write(U.UserName + "," + U.LoginName + "," + U.Password + "," + U.UserRole + "\n");
							}
							BW.close();
							FW.close();
							F = null;

							System.out.println("!...Program Closed...!");
							CanIkeepRunningtheprogram = false;
						}
					}
				}

				public static void AddUser() {
					Scanner S = new Scanner(System.in);
					User U = new User();
					System.out.println("Enter the UseName :");
					U.UserName = S.nextLine();
					System.out.println("Enter the LoginName :");
					U.LoginName = S.nextLine();
					System.out.println("Enter the Password :");
					U.Password = S.nextLine();
					System.out.println("Enter the ConfirmPassword :");
					U.ConfirmPassword = S.nextLine();
					System.out.println("Enter the UserRole :");
					U.UserRole = S.nextLine();

					System.out.println("UserName : " + U.UserName);
					System.out.println("Login : " + U.LoginName);
					System.out.println("Password : " + U.Password);
					System.out.println("UserRole" + U.UserRole);

					AL.add(U);
				}

				public static void EditUser(String EditUser) {
					Scanner S = new Scanner(System.in);
					for (User U : AL)
						if (U.UserName.equalsIgnoreCase(EditUser)) {
							System.out.println("....User Found....");
							System.out.println("Enter the UseName :");
							U.UserName = S.nextLine();
							System.out.println("Enter the LoginName :");
							U.LoginName = S.nextLine();
							System.out.println("Enter the Password :");
							U.Password = S.nextLine();
							System.out.println("Enter the ConfirmPassword :");
							U.ConfirmPassword = S.nextLine();
							System.out.println("Enter the UserRole :");
							U.UserRole = S.nextLine();
							System.out.println("Information Updated");
							return;
						}
				}

				public static void DeleteUser(String DeleteUser) {
					Iterator<User> USER = AL.iterator();
					while (USER.hasNext()) {
						User U = USER.next();
						if (U.UserName.equalsIgnoreCase(DeleteUser)) {
							USER.remove();
							System.out.println(U.UserName + " has been deleted");
						}
					}

				}

				public static void SearchUser(String SearchUser) {
					for (User U : AL) {
						if (U.UserName.equalsIgnoreCase(SearchUser)) {
							System.out.println(U.UserName);
							System.out.println(U.LoginName);
							System.out.println(U.Password);
							System.out.println(U.UserRole);
							return;
						}
					}
				}

				public static void MemoryReader() throws IOException {
					File F = new File("C:\\Users\\pandi\\eclipse-workspace\\ShopeManagement\\src\\UserManagement\\User.txt");

					FileReader FR = new FileReader(F);

					BufferedReader BR = new BufferedReader(FR);

					String Line;

					while ((Line = BR.readLine()) != null) {
						User u = new User();

						String[] UserData = Line.split(",");
						if (UserData.length > 3) {
							u.UserName = UserData[0];
							u.LoginName = UserData[1];
							u.Password = UserData[2];
							u.UserRole = UserData[3];
							AL.add(u);
						}
					}
				}

				public static boolean LoginProcess(String UserName, String Password) {
					Iterator<User> Login = AL.iterator();
					while (Login.hasNext()) {
						User U = Login.next();
						if (U.UserName.equalsIgnoreCase(UserName) && U.Password.equalsIgnoreCase(Password)) {
							return true;
						}

					}
					return false;
				}
			}
			
		