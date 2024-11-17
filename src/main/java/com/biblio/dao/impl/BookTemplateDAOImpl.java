package com.biblio.dao.impl;

import com.biblio.dao.IBookTemplateDAO;
import com.biblio.entity.Book;
import com.biblio.entity.BookTemplate;
import com.biblio.entity.MediaFile;
import com.biblio.enumeration.EBookMetadataStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class BookTemplateDAOImpl extends GenericDAOImpl<BookTemplate> implements IBookTemplateDAO {
    public BookTemplateDAOImpl() {
        super(BookTemplate.class);
    }

    @Override
    public BookTemplate findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<BookTemplate> findAll() {
        return super.findAll();
    }

    public static void main(String[] args) {
        BookTemplateDAOImpl dao = new BookTemplateDAOImpl();
        List<BookTemplate> bookTemplates = dao.findAll();

        for (BookTemplate template : bookTemplates) {
            System.out.println(template.getId());
            List<MediaFile> sortedMediaFiles = new ArrayList<>(template.getMediaFiles());
            sortedMediaFiles.sort(Comparator.comparing(MediaFile::getId));

            // In các MediaFile đã sắp xếp
            for (MediaFile mediaFile : sortedMediaFiles) {
                System.out.println(mediaFile.getFileName());
            }

            System.out.println("--------------");
            System.out.println("--------------");
//            Set<Book> books = template.getBooks();
//            long soldCount = books.stream().filter(book -> book.getBookMetadata().getStatus() == EBookMetadataStatus.SOLD).count();
//            long inStockCount = books.stream().filter(book -> book.getBookMetadata().getStatus() == EBookMetadataStatus.IN_STOCK).count();

        }
    }
}
