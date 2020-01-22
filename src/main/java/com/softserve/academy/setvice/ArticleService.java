package com.softserve.academy.setvice;

import com.softserve.academy.model.Article;
import com.softserve.academy.repository.IRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService implements IService<Article> {

    private IRepository<Article> articleIRepository;

    public ArticleService(IRepository<Article> articleIRepository) {
        this.articleIRepository = articleIRepository;
    }

    @Override
    public void create(Article entity) {
        if (entity != null) {
            articleIRepository.create(entity);
        } else {
            throw new RuntimeException("The Article cannot be NULL!");
        }
    }

    @Override
    public Article readById(long id) {
        if (id > 0) {
            return articleIRepository.readById(id);
        }
        throw new RuntimeException("The ID must be positive number!");
    }

    @Override
    public void update(Article entity) {
        if (entity != null) {
            articleIRepository.update(entity);
        } else {
            throw new RuntimeException("The Article cannot be NULL!");
        }
    }

    @Override
    public void delete(long id) {
        if (id > 0) {
            articleIRepository.delete(id);
        } else {
            throw new RuntimeException("The ID must be positive number!");
        }
    }

    @Override
    public List<Article> readAll() {
        List<Article> articles = articleIRepository.readAll();
        if (!articles.isEmpty()) {
            return articles;
        }
        throw new RuntimeException("Not found any Articles!");
    }
}
