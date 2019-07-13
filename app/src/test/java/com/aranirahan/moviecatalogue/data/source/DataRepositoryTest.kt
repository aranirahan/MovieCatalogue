package com.aranirahan.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aranirahan.moviecatalogue.data.source.locale.LocaleRepository
import com.aranirahan.moviecatalogue.data.source.remote.RemoteRepository
import com.aranirahan.moviecatalogue.ui.main.utils.FakeDataDummy
import com.aranirahan.moviecatalogue.ui.main.utils.LiveDataTestUtil
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class DataRepositoryTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val local = mock(LocaleRepository::class.java)
    private val remote = mock(RemoteRepository::class.java)
    private val dataRepository = FakeDataRepository(local, remote)

    private val movieResponseList = FakeDataDummy.generateRemoteDummyMovies()
    private val idMovieResponse = movieResponseList[0].id
    private val movieResponse = FakeDataDummy.getRemoteMovieById(idMovieResponse)

    private val tvShowResponseList = FakeDataDummy.generateRemoteDummyTvShows()
    private val idTvShowResponse = tvShowResponseList[0].id
    private val tvShowResponse = FakeDataDummy.getRemoteTvShowById(idTvShowResponse)

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }

    @Test
    fun getMovieResponseList() {
//        `when`(remote.getMovieResponseList()).thenReturn(movieResponseList)
//        val movie = dataRepository.getMovies()
//        verify(remote).getMovieResponseList()
//        assertNotNull(movie)
//        assertEquals(movieResponseList.size, movie.size)

        try {
            Thread.sleep(2100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

//        doAnswer { invocation ->
//            (invocation.arguments[0] as RemoteRepository.GetMoviesCallback)
//                .onMoviesReceived(movieResponseList)
//            null
//        }.`when`(remote).getMovieResponseList(any(RemoteRepository.GetMoviesCallback::class.java))

        doAnswer {
            val callback = it.arguments[0] as RemoteRepository.GetMoviesCallback
            callback.onMoviesReceived(movieResponseList)
            null
        }.`when`(remote).getMovieResponseList(any(RemoteRepository.GetMoviesCallback::class.java))


//        val result = LiveDataTestUtil.getValue(dataRepository.getMovies())
//
//        verify(
//            remote,
//            times(1)
//        ).getMovieResponseList(any(RemoteRepository.GetMoviesCallback::class.java))
//
//        assertEquals(movieResponseList.size, result.size)
    }

//    @Test
//    fun getMovieResponse() {
//        `when`(remote.getMovieResponse(idMovieResponse)).thenReturn(movieResponse)
//        val movie = dataRepository.getMovie(idMovieResponse)
//        verify(remote).getMovieResponse(idMovieResponse)
//        assertNotNull(movie)
//        assertEquals(idMovieResponse, movie.id)
//    }
//
//    @Test
//    fun getTvShowResponseList() {
//        `when`(remote.getTvShowResponseList()).thenReturn(tvShowResponseList)
//        val tvShows = dataRepository.getTvShows()
//        verify(remote).getTvShowResponseList()
//        assertNotNull(tvShows)
//        assertEquals(tvShowResponseList.size, tvShows.size)
//    }
//
//    @Test
//    fun getTvShowResponse() {
//        `when`(remote.getTvShowResponse(idTvShowResponse)).thenReturn(tvShowResponse)
//        val tvShow = dataRepository.getTvShow(idTvShowResponse)
//        verify(remote).getTvShowResponse(idTvShowResponse)
//        assertNotNull(tvShow)
//        assertEquals(idTvShowResponse, tvShow.id)
//    }
}