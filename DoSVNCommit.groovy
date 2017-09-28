import groovy.util.logging.Log4j
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager
import org.tmatesoft.svn.core.wc.ISVNOptions
import org.tmatesoft.svn.core.wc.SVNCommitClient
import org.tmatesoft.svn.core.wc.SVNWCUtil
import org.tmatesoft.svn.core.SVNException

@Log4j
public class DoSVNCommit extends SVNCommitClient{

	public DoSVNCommit(ISVNAuthenticationManager authManager) {
		super(authManager, SVNWCUtil.createDefaultOptions(true))
	}

	public void commit(File[] files, boolean keeplocks, String commitMessage, boolean force, boolean recursive) {
		try{
			this.doCommit(files, keeplocks, commitMessage, force, recursive)
			log.info("Commit bei Datei(en) " + files + "erfolgreich")
		} catch (SVNException svnException){
			log.info("Commit bei Datei(en) " + files + " fehlgeschlagen mit \n" + svnException.getMessage())
		}
	}
}