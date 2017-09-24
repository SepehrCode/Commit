import groovy.util.logging.Log4j
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager
import org.tmatesoft.svn.core.SVNException;

@Log4j
public class Committer {

	public String pathToFiles = "C:/Projekte/SVN-Commit/verzeichnisse.list"
	private ISVNAuthenticationManager authManager

	public static void main(String[] args) {
		log.info("Starte Commit der Verzeichnisse...")
		new Committer()
	}

	public Committer() {
		commitInstance(readPathsToCommit(pathToFiles))
	}


	private File[] readPathsToCommit(String path){
		def listedPaths = []
		new FileReader(path).eachLine { line ->
			try{
				listedPaths << new File(line)
			} catch (FileNotFoundException fileNotFoundException) {
				log.info("Commit-Datei " + line + " existiert nicht: " + fileNotFoundException.getMessage())
			} catch (Exception e){
				log.info(e.getMessage())
			}
		}
		return listedPaths
	}
	public void commitInstance(File[] file){
		new DoSVNCommit(authManager).commit(file, true, "Ich hab es noch nicht geschafft", true, true)
	}
}