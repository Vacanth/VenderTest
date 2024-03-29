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

public class ProductSpecificationDaoImpl extends BaseDaoImpl implements ProductSpecificationDao {

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#save(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void insert (ProductSpecification productSpecification) {
		// TODO Auto-generated method stub
		
		getHibernateTemplate().save(productSpecification);
		
		
	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#update(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void update(ProductSpecification productSpecification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(productSpecification);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#delete(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public void delete(ProductSpecification productSpecification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(productSpecification);

	}

	/* (non-Javadoc)
	 * @see com.vendertool.inventory.DBL.BO.MerchantProductDao#findByStockCode(com.vendertool.inventory.DBL.BO.MerchantProduct)
	 */
	public List<ProductSpecification> findByRefIdAndRefType(long refId,Byte refType) {
		// TODO Auto-generated method stub
		String sql = "select * from Product_Specification where ref_id = :ref_id and ref_type = :ref_type";
		SQLQuery query=getSession().createSQLQuery(sql);
		query.setParameter("ref_id", refId);
		query.addEntity(ProductSpecification.class);
		query.setParameter("ref_type", refType);
		query.addEntity(ProductSpecification.class);
		List<ProductSpecification> results = query.list();
		return  results;
	}

}
