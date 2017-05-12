package main.java.com.hj.shop.action.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import main.java.com.hj.shop.entity.CategorySecond;
import main.java.com.hj.shop.entity.Product;
import main.java.com.hj.shop.service.CategorySecondService;
import main.java.com.hj.shop.service.ProductService;
import main.java.com.hj.shop.utils.PageBean;

/**
 * 后台商品管理的Action
 * @author Administrator
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {

	//模型驱动获取数据
	private Product product = new Product();
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}
	
	//注入商品的Service
	private ProductService productService ;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//注入二级分类的Service
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	//接收当前页数
	private Integer currentPage;
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
	//struts2文件上传的参数
	//一、表单中文件上传的name和参数名一样
	private File upload;
	//二、文件的文件名
	private String uploadFileName;
	//三、文件的MIME类型
	private String uploadContextType;
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}


	/**
	 * 带分页查询所有的商品
	 * @return
	 */
	public String findProduct(){
		PageBean<Product> pb = productService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().set("pb", pb);
		return "findProduct";
	}
	
	
	/**
	 * 查询二级分类的数据并跳转到添加商品页面
	 * @return
	 */
	public String addProduct(){
		List<CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "addProduct";
	}
	
	
	/**
	 * 添加商品
	 * @return
	 */
	public String save(){
		//设置商品的日期
		product.setPdate(new Date());
		
		//文件上传
		if(upload!=null){
			//获取文件上传的绝对路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			//创建一个文件
			File file = new File(realPath+"//"+uploadFileName);
			//上传
			try {
				org.apache.commons.io.FileUtils.copyFile(upload, file);
				
				//复制一份到eclipse工作空间
				File f = new File("F:\\Eclipse\\shop\\src\\main\\webapp\\products\\"+uploadFileName);
				FileUtils.copyFile(upload, f);
				System.out.println("================================图片复制到工作空间成功===================================");
			} catch (IOException e) {
				e.printStackTrace();
			}
			//将文件的路径存入商品对象
			product.setImage("products/"+uploadFileName);
		}
		productService.save(product);
		return "save";
	}
	
	
	/**
	 * 删除一个商品
	 */
	public String delete(){
		//根据页面传递的id查询商品
		product = productService.findByPid(product.getPid());
		//删除图片
		String path = product.getImage();
		if(path!=null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/"+path);
			File file = new File(realPath);
			file.delete();
			
			
			//删除工作空间的图片
			File f = new File("F:\\Eclipse\\shop\\src\\main\\webapp\\products\\"+uploadFileName);
			f.delete();
			System.out.println("================================删除工作空间图片成功===================================");
		}else{
			System.out.println("图片不存在");
		}
		//删除商品
		productService.delete(product);
		return "delete";
	}
	
	
	
	/**
	 * 跳转到编辑商品页面
	 * @return
	 */
	public String edit(){
		//根据页面传递的id查询商品
		product = productService.findByPid(product.getPid());
		//查询所有的二级分类
		List<CategorySecond> csList = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "edit";
	}
	
	
	/**
	 * 更新商品
	 */
	public String update(){
		//更新商品的日期
		product.setPdate(new Date());
		//判断 是否要更新图片
		if(upload!=null){
			
			//删除原图片
			String path2 = product.getImage();
			if(path2!=null){
				String realPath2 = ServletActionContext.getServletContext().getRealPath("/"+path2);
				File file2 = new File(realPath2);
				file2.delete();
				
			}
			
			
			//删除工作空间的图片
			File f = new File("F:\\Eclipse\\shop\\src\\main\\webapp\\"+path2);
			if(f.delete()){
				System.out.println("================================删除工作空间图片成功===================================");
			}
			
			
			
			
			//需要更新图片
			//获取文件上传的绝对路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			//创建一个文件
			File file = new File(realPath+"//"+uploadFileName);
			//上传
			try {
				org.apache.commons.io.FileUtils.copyFile(upload, file);
				
				//复制一份到eclipse工作空间
				File f2 = new File("F:\\Eclipse\\shop\\src\\main\\webapp\\products\\"+uploadFileName);
				FileUtils.copyFile(upload, f2);
				System.out.println("================================图片复制到工作空间成功===================================");
			} catch (IOException e) {
				e.printStackTrace();
			}
			//将文件的路径存入商品对象
			product.setImage("products/"+uploadFileName);
			
		}
		
		
		//保存商品的信息到数据库
		productService.update(product);
		return "update";
	}

}
