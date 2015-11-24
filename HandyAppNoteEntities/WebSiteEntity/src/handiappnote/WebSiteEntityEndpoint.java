package handiappnote;

import handiappnote.EMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "websiteentityendpoint", namespace = @ApiNamespace(ownerDomain = "mycompany.com", ownerName = "mycompany.com", packagePath = "services"))
public class WebSiteEntityEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listWebSiteEntity")
	public CollectionResponse<WebSiteEntity> listWebSiteEntity(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<WebSiteEntity> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr
					.createQuery("select from WebSiteEntity as WebSiteEntity");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<WebSiteEntity>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (WebSiteEntity obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<WebSiteEntity> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getWebSiteEntity")
	public WebSiteEntity getWebSiteEntity(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		WebSiteEntity websiteentity = null;
		try {
			websiteentity = mgr.find(WebSiteEntity.class, id);
		} finally {
			mgr.close();
		}
		return websiteentity;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param websiteentity the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertWebSiteEntity")
	public WebSiteEntity insertWebSiteEntity(WebSiteEntity websiteentity) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsWebSiteEntity(websiteentity)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(websiteentity);
		} finally {
			mgr.close();
		}
		return websiteentity;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param websiteentity the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateWebSiteEntity")
	public WebSiteEntity updateWebSiteEntity(WebSiteEntity websiteentity) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsWebSiteEntity(websiteentity)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(websiteentity);
		} finally {
			mgr.close();
		}
		return websiteentity;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeWebSiteEntity")
	public void removeWebSiteEntity(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		try {
			WebSiteEntity websiteentity = mgr.find(WebSiteEntity.class, id);
			mgr.remove(websiteentity);
		} finally {
			mgr.close();
		}
	}

	private boolean containsWebSiteEntity(WebSiteEntity websiteentity) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			WebSiteEntity item = mgr.find(WebSiteEntity.class,
					websiteentity.getURL());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
