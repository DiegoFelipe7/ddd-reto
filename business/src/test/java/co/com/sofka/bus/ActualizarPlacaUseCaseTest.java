package co.com.sofka.bus;

import co.com.sofka.business.repository.DomainEventRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ActualizarPlacaUseCaseTest {

    @InjectMocks
    private  ActualizarPlacaUseCase actualizarPlacaUseCase;

    @Mock
    DomainEventRepository repository;

}
