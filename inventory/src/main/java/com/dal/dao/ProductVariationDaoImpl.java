/**
 * 
 */
package com.dal.dao;
import java.util.List;

import org.hibernate.SQLQuery;


import com.vendertool.common.dal.BaseDaoImpl;

/**
 * @author murali
 *HibernateDaoSupport
 */

public class ProductVariationDaoImpl extends BaseDaoImpl implements ProductVariationDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ProductVariation productVariation) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(productVariation);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ProductVariation productVariation) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(productVariation);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ProductVariation productVariation) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(productVariation);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ProductVariation> findByProductId(long productId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_VariationDao where product_id = :product_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_id", productId);
		query.addEntity(ProductVariation.class);
		List<ProductVariation> results = query.list();
		return  results;
	}
	
	public List<ProductVariation> findByProductVariationId(long productVariationId) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_VariationDao where product_variations_id = :product_variations_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_variations_id", productVariationId);
		query.addEntity(ProductVariation.class);
		List<ProductVariation> results = query.list();
		return  results;
	}

}
