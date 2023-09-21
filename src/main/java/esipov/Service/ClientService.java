package esipov.Service;

import esipov.Model.Post;

import java.util.List;

public interface ClientService {
    /**
     * Создает новый пост
     * @param post - для создания
     */
    void create(Post post);

    /**
     * Возвращает список всех имеющихся постов
     * @return список постоп
     */
    List<Post> readAll();

    /**
     * Возвращает пост по его ID
     * @param id - ID поста
     * @return - объект поста с заданным ID
     */
    Post read(int id);

    /**
     * Обновляет пост с заданным ID,
     * в соответствии с переданным посту
     * @param post - пост в соответсвии с которым нужно обновить данные
     * @param id - id поста которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Post post, int id);

    /**
     * Удаляет пост с заданным ID
     * @param id - id поста, которого нужно удалить
     * @return - true если пост был удален, иначе false
     */
    boolean delete(int id);
}
