package hu.tmx.mybooksapp.service;

import hu.tmx.mybooksapp.interfaces.AuthorDao;
import hu.tmx.mybooksapp.model.Author;
import hu.tmx.mybooksapp.model.BaseData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("AuthorDaoMem")
public class AuthorDaoMem implements AuthorDao {

    @Override
    public List<Author> getAllAuthor() {
        return BaseData.authors;
    }
}
