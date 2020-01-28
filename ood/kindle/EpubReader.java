package ood.kindle;

class EpubReader extends EBookReader{

	public EpubReader(Book b) {
		super(b);
	}

	@Override
	public String readBook() {
		return book.getFormat().getContent();
	}

	@Override
	public String displayReaderType() {
		return "Using EPUB reader";
	}
}