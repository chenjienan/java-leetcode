package ood.kindle;

class MobiReader extends EBookReader {

	public MobiReader(Book b) {
		super(b);
	}

	@Override
	public String readBook() {
		return book.getFormat().getContent();
	}

	@Override
	public String displayReaderType() {
		return "Using MOBI reader";
	}

}