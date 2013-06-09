package li260.InterfaceGraphique.file;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ExtFileFilter extends FileFilter {

	private String extension, description;

	public ExtFileFilter(String ext, String descrip) {
		this.extension = ext;
		this.description = descrip;
	}

	@Override
	public boolean accept(File file) {
		return (file.isDirectory() || file.getName().endsWith(this.extension));
	}

	@Override
	public String getDescription() {
		return this.extension + " - " + this.description;
	}
}
