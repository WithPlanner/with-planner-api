package withplanner.withplanner_api;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import withplanner.withplanner_api.domain.Address;
import withplanner.withplanner_api.domain.User;
import withplanner.withplanner_api.dto.UserRequestDto;
import withplanner.withplanner_api.repository.UserRepository;
import withplanner.withplanner_api.service.UserService;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDb {
    //테스트용 데이터를 입력하는 파일입니다.
    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.userInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final UserRepository userRepository;
        private final UserService userService;

        //회원생성
        public void userInit(){
            //user1
            String email ="a";
            String pw= "a";
            String name = "이름a";
            String zipcode = "11111";
            String baseAddress = "서울시 성북구 성북동 1234번지";
            String detailedAddress="12동 1435호";
            String role = "ROLE_USER";
            UserRequestDto userRequestDto = new UserRequestDto();
            userRequestDto.setEmail(email);
            userRequestDto.setPw(pw);
            userRequestDto.setName(name);
            userRequestDto.setZipcode(zipcode);
            userRequestDto.setBaseAddress(baseAddress);
            userRequestDto.setDetailedAddress(detailedAddress);
            userService.join(userRequestDto,role);

            //user2
            User user2 = User.builder()
                    .email("b")
                    .pwd("b")
                    .name("이름b")
                    .address(new Address("22222","서울시 성북구 성북동 1234번지","22동 22호"))
                    .build();
            userRepository.save(user2);

            //user3
            User user3 = User.builder()
                    .email("c")
                    .pwd("c")
                    .name("이름c")
                    .address(new Address("33333","서울시 성북구 성북동 1234번지","33동 33호"))
                    .build();
            userRepository.save(user3);

        }

    }


}
