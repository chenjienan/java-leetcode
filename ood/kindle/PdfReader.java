package ood.kindle;

class PdfReader extends EBookReader{

	public PdfReader(Book b) {
		super(b);
	}

	@Override
	public String readBook() {
		return book.getFormat().getContent();
	}

	@Override
	public String displayReaderType() {
		return "Using PDF reader";
	}
}