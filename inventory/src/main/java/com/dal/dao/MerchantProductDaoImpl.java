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

public class MerchantProductDaoImpl extends BaseDaoImpl implements MerchantProductDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (MerchantProduct merchantProduct) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(merchantProduct);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(MerchantProduct merchantProduct) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(merchantProduct);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(MerchantProduct merchantProduct) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(merchantProduct);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<MerchantProduct> findByAccountId(long accountId) {
		// TODO Auto-generated method stub
		String sql = "select * from merchant_product where account_id = :account_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("account_id", accountId);
		query.addEntity(MerchantProduct.class);
		List<MerchantProduct> results = query.list();
		return  results;
	}

	public List<MerchantProduct> findByProductId(long productId) {
		// TODO Auto-generated method stub
		String sql = "select * from merchant_product where product_id = :product_id";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("product_id", productId);
		query.addEntity(MerchantProduct.class);
		List<MerchantProduct> results = query.list();
		return  results;
	}
}
