package com.claritae.maintainance.service.admin;

import com.claritae.maintainance.model.equipment.Compressor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class AdminServiceImplTest {

    @Mock
    private AdminService adminServiceImpl;

    @BeforeAll
    public void setup() {
            MockitoAnnotations.openMocks(this);
            adminServiceImpl = mock(AdminService.class);
    }

    @Test
    public void when_compressor_is_created_then_return_compressor() {
       Compressor compressor = new Compressor();
       compressor.setName("TestCompressor");


        when(adminServiceImpl.create(compressor))
                .thenReturn(compressor);

        Compressor compressor1 = adminServiceImpl.create(compressor);
        verify(adminServiceImpl, times(1)).create(compressor);

        assertThat(compressor).isNotNull();

    }
}
