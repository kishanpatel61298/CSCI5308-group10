package dal.asdc.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dal.asdc.model.Player;
import dal.asdc.model.interfaces.IPlayer;

@RunWith(MockitoJUnitRunner.class)
class Player_persistenceTest {
	
	@Mock
	private Jdbc_connection jdbc_conn;
	
	@Mock
	private Connection conn;
	
	@Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private Player player;
    
    @Before
    public void setUp() throws SQLException {
        when(jdbc_conn.createDBConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(preparedStatement);
        doNothing().when(preparedStatement).setString(anyInt(), anyString());
        doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
    }
	
	@Test
    public void testSave_record() throws SQLException {
        when(preparedStatement.executeUpdate()).thenReturn(1);
        when(conn.prepareStatement(anyString(), anyInt())).thenReturn(preparedStatement);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        Player_persistence player_persistence = new Player_persistence();
        IPlayer iPlayer = new Player();
        iPlayer.setPlayer_id(1);
        iPlayer.setPlayer_email("reshma@gmail");
        iPlayer.setPlayer_name("Reshma");
        iPlayer.setPlayer_password("Reshma@123");
        iPlayer.setAcc_created_date(null);
        player_persistence.save_record(iPlayer);
        verify(jdbc_conn, times(1)).createDBConnection();
        verify(conn, times(1)).prepareStatement(anyString(), anyInt());
        verify(preparedStatement, times(4)).setString(anyInt(), anyString());
        verify(preparedStatement, times(1)).setInt(anyInt(), anyInt());
        verify(preparedStatement, times(1)).executeUpdate();
    }

	@Test
	void testSelect_all_record() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate_record() {
		fail("Not yet implemented");
	}

	@Test
	void testFilter_by_id() {
		fail("Not yet implemented");
	}

}
