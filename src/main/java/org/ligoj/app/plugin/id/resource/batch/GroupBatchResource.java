package org.ligoj.app.plugin.id.resource.batch;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;
import org.ligoj.app.plugin.id.resource.IdentityResource;
import org.springframework.stereotype.Service;

/**
 * Batch resource for group.
 */
@Path(IdentityResource.SERVICE_URL + "/group/batch")
@Service
@Produces(MediaType.APPLICATION_JSON)
public class GroupBatchResource extends AbstractBatchResource<GroupImportEntry> {

	/**
	 * Default CSV headers for imports.
	 */
	private static final String[] DEFAULT_IMPORT_CSV_HEADERS = { "name", "type", "parent", "owner", "assistant", "department" };

	/**
	 * Upload a file of entries to create or update groups. The whole entry is replaced.
	 * 
	 * @param uploadedFile
	 *            Entries file to import. Currently support only CSV format.
	 * @param columns
	 *            the CSV header names.
	 * @param encoding
	 *            CSV encoding. Default is UTF-8.
	 * @param quiet
	 *            Optional flag to turn-off the possible notification such as mail. Default value is <code>false</code>.
	 * @return the import identifier.
	 */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("full")
	public long full(@Multipart(value = "csv-file") final InputStream uploadedFile,
			@Multipart(value = "columns", required = false) final String[] columns,
			@Multipart(value = "encoding", required = false) final String encoding,
			@Multipart(value = "quiet", required = false) final Boolean quiet) throws IOException {
		return batch(uploadedFile, columns, encoding, DEFAULT_IMPORT_CSV_HEADERS, GroupImportEntry.class, GroupFullTask.class, quiet);
	}
}