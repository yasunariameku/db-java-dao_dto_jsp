package service;

import java.sql.Connection;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class ProductService {

	
	//引数なしコンストラクタ
	public ProductService() {
	}
	
	
	//idが一致しているデータを取ってくるセレクトメソッド

	public Product findById(Integer product_id) {
        try (Connection conn = DbUtil.getConnection()) {
        	
            //System.out.println(product_id);
        	//↑で引数の値を受け取れている。

        	//ProductDaoのインスタンスを生成
        	ProductDao pd = new ProductDao(conn);
        	//ProductDaoのインスタンスメソッドのfindByIdメソッドを呼び出す
        	Product product = pd.findById(product_id);

            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
	
}
