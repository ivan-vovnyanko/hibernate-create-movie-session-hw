package mate.academy.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import mate.academy.dao.MovieSessionDao;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.MovieSession;
import mate.academy.service.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao movieSessionDao;

    @Override
    public MovieSession add(MovieSession movieSession) {
        return movieSessionDao.add(movieSession);
    }

    @Override
    public MovieSession get(Long id) {
        Optional<MovieSession> optionalMovieSession = movieSessionDao.get(id);
        if (optionalMovieSession.isEmpty()) {
            throw new NoSuchElementException("Couldn't find movie session by id " + id);
        }
        return optionalMovieSession.get();
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }
}
