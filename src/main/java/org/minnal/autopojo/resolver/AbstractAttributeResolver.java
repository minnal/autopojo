/**
 * 
 */
package org.minnal.autopojo.resolver;

import org.apache.commons.beanutils.PropertyUtils;
import org.minnal.autopojo.AttributeMetaData;
import org.minnal.autopojo.AutoPojoException;

/**
 * @author ganeshs
 *
 */
public abstract class AbstractAttributeResolver implements AttributeResolver {

	protected void setAttribute(Object pojo, AttributeMetaData attribute, Object value) {
		try {
			PropertyUtils.setProperty(pojo, attribute.getName(), value);
		} catch (Exception e) {
			throw new AutoPojoException(e);
		}
	}
	
	public void resolve(Object pojo, AttributeMetaData attribute, int maxDepth) {
		Object value = maxDepth >= 0 ? resolve(attribute.getType(), maxDepth, attribute.getTypeArguments()) : null;
		setAttribute(pojo, attribute, value);
	}

}
