package ProductManagement;

		import java.io.BufferedReader;
		import java.io.BufferedWriter;
		import java.io.File;
		import java.io.FileReader;
		import java.io.FileWriter;
		import java.io.IOException;
		import java.util.ArrayList;
		import java.util.Iterator;
		import java.util.Scanner;


		public class Product_Management {
			static ArrayList<Product> PL = new ArrayList<>();

			public static void ProductMangement() throws IOException {
				MemoryReader();
				Scanner s = new Scanner(System.in);
				boolean CanIKeepRunningTheProgram = true;
				while (CanIKeepRunningTheProgram == true) {
					System.out.println(">>>>>>..ProductMangement..<<<<<<");
					System.out.println("1.AddProduct");
					System.out.println("2.EditProduct");
					System.out.println("3.DeleteProduct");
					System.out.println("4.SearchProduct");
					System.out.println("5.Quit");

					int OptionSelectbyUser = s.nextInt();

					if (OptionSelectbyUser == ProductOptions.AddProduct) {
						AddProduct();
					} else if (OptionSelectbyUser == ProductOptions.EditProduct) {
						System.out.println("Enter the Product Name to edit :");
						s.nextLine();
						String PEdit = s.nextLine();
						EditProduct(PEdit);
					} else if (OptionSelectbyUser == ProductOptions.DeleteProduct) {
						System.out.println("Enter the Product Name to Delete");
						s.nextLine();
						String PDelete = s.nextLine();
						DeleteProduct(PDelete);
					} else if (OptionSelectbyUser == ProductOptions.SearchProduct) {
						System.out.println("Enter the Product Name ");
						s.nextLine();
						String PSearch = s.nextLine();
						SearchProduct(PSearch);
					} else if (OptionSelectbyUser == ProductOptions.QUIT) {
						File F = new File("C:\\Users\\pandi\\eclipse-workspace\\ShopeManagement\\src\\ProductManagement\\Product.txt");

						FileWriter FW = new FileWriter(F, false);

						BufferedWriter BW = new BufferedWriter(FW);

						for (Product product : PL) {
							BW.write(product.ProductID + "," + product.ProductName + "," + product.ProductPrice + ","
									+ product.ProductQuantity + ";" + product.ProductCategory + "\n");

						}
						BW.close();
						FW.close();
						F = null;
						System.out.println("!...Program closed...!");
						CanIKeepRunningTheProgram = false;
					}
				}
			}

			public static void AddProduct() {
				Scanner s = new Scanner(System.in);
				Product ProductObject = new Product();
				System.out.println("Enter the ProductName ");
				ProductObject.ProductName = s.nextLine();
				System.out.println("Enter the ProductID ");
				ProductObject.ProductID = s.nextLine();
				System.out.println("Enter the ProductPrice");
				ProductObject.ProductPrice = s.nextLine();
				System.out.println("Enter the ProductQuantity");
				ProductObject.ProductQuantity = s.nextLine();
				System.out.println("Enter the ProductCategory");
				ProductObject.ProductCategory = s.nextLine();

				System.out.println("\n");
				System.out.println("ProductID :" + ProductObject.ProductID);
				System.out.println("ProductName :" + ProductObject.ProductName);
				System.out.println("ProductPrice :" + ProductObject.ProductPrice);
				System.out.println("ProductQuantity :" + ProductObject.ProductQuantity);
				System.out.println("ProductCategory :" + ProductObject.ProductCategory);

				PL.add(ProductObject);
			}

			public static void EditProduct(String PEdit) {
				for (Product P : PL)
					if (P.ProductName.equalsIgnoreCase(PEdit)) {
						Scanner s = new Scanner(System.in);
						System.out.println("Enter the ProductName ");
						P.ProductName = s.nextLine();
						System.out.println("Enter the ProductID ");
						P.ProductID = s.nextLine();
						System.out.println("Enter the ProductPrice");
						P.ProductPrice = s.nextLine();
						System.out.println("Enter the ProductQuantity");
						P.ProductQuantity = s.nextLine();
						System.out.println("Enter the ProductCategory");
						P.ProductCategory = s.nextLine();
						System.out.println("Information Updated..");
						return;

					}
			}

			public static void DeleteProduct(String PDelete) {
				Iterator<Product> ProductIterator = PL.iterator();
				while (ProductIterator.hasNext()) {
					Product P = ProductIterator.next();
					if (P.ProductName.equalsIgnoreCase(PDelete)) {
						ProductIterator.remove();
						System.out.println(P.ProductName + " has been deleted");
					}
				}
				System.out.println("Product not found");
			}

			public static void SearchProduct(String PSearch) {
				for (Product P : PL) {
					if (P.ProductName.equalsIgnoreCase(PSearch)) {
						System.out.println("ProductID :" + P.ProductID);
						System.out.println("ProductName :" + P.ProductName);
						System.out.println("ProductPrice :" + P.ProductPrice);
						System.out.println("ProductQuantity :" + P.ProductQuantity);
						System.out.println("ProductCategory :" + P.ProductCategory);
					}
				}
			}

			public static void MemoryReader() throws IOException {
				File F = new File("C:\\Users\\pandi\\eclipse-workspace\\ShopeManagement\\src\\ProductManagement\\Product.txt");

				FileReader FR = new FileReader(F);

				BufferedReader BR = new BufferedReader(FR);

				String Line;
				while ((Line = BR.readLine()) != null) {
					Product P = new Product();
					String[] arraylist = Line.split(",");
					if (arraylist.length > 4) {
						P.ProductID = arraylist[0];
						P.ProductName = arraylist[1];
						P.ProductPrice = arraylist[2];
						P.ProductQuantity = arraylist[3];
						P.ProductCategory = arraylist[4];
						PL.add(P);
					}
				}
		        BR.close();
		        FR.close();
		        F= null;
			}
		}
			