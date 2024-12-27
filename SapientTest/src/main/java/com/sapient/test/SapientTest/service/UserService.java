package com.sapient.test.SapientTest.service;
import com.sapient.test.SapientTest.dto.*;
import com.sapient.test.SapientTest.entity.*;
import com.sapient.test.SapientTest.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository repository;

    private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserResponse fetchUserData() {
        String url = "https://dummyjson.com/users";
        UserResponse users = restTemplate.getForObject(url, UserResponse.class);
        if(Objects.nonNull(users)) {
            log.info(users.toString());
            saveDataToDb(users);
            return users;
        }
        return null;
    }

    public void saveDataToDb(UserResponse users) {
        List<UserEntity> userToSave = new ArrayList<>();
        for(User user : users.getUsers()) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(user.getId());
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setMaidenName(user.getMaidenName());
            userEntity.setAge(user.getAge());
            userEntity.setGender(user.getGender());
            userEntity.setEmail(user.getEmail());
            userEntity.setPhone(user.getPhone());
            userEntity.setUsername(user.getUsername());
            userEntity.setPassword(user.getPassword());
            userEntity.setBirthDate(user.getBirthDate());
            userEntity.setImage(user.getImage());
            userEntity.setBloodGroup(user.getBloodGroup());
            userEntity.setHeight(user.getHeight());
            userEntity.setWeight(user.getWeight());
            userEntity.setEyeColor(user.getEyeColor());
            userEntity.setIp(user.getIp());

            if (user.getHair() != null) {
                userEntity.setHair(mapHairDTOtoEntity(user.getHair()));
            }

            userEntity.setIp(user.getIp());

            // Map AddressEntity to AddressDTO
            if (user.getAddress() != null) {
                userEntity.setAddress(mapAddressDTOToEntity(user.getAddress()));
            }

            userEntity.setMacAddress(user.getMacAddress());
            userEntity.setUniversity(user.getUniversity());
            userEntity.setEin(user.getEin());
            userEntity.setSsn(user.getSsn());
            userEntity.setUserAgent(user.getUserAgent());

            // Map CryptoEntity to CryptoDTO
            if (user.getCrypto() != null) {
                userEntity.setCrypto(mapCryptoDtoToEntity(user.getCrypto()));
            }

            userEntity.setRole(user.getRole());

            // Map BankEntity and CompanyEntity similarly
            if (user.getBank() != null) {
                userEntity.setBank(mapBankDtoToEntity(user.getBank()));
            }

            if (user.getCompany() != null) {
                userEntity.setCompany(mapCompanyDtoToEntity(user.getCompany()));
            }


            userToSave.add(userEntity);
        }

        repository.saveAll(userToSave);
    }

    public CompanyEntity mapCompanyDtoToEntity(Company company) {
        CompanyEntity companyEntity = new CompanyEntity();
        CompanyAddressEntity companyAddressEntity = new CompanyAddressEntity();
        companyEntity.setAddress(mapCompanyAddressDtoToEntity(company.getAddress()));
        companyEntity.setDepartment(company.getDepartment());
        companyEntity.setName(company.getName());
        companyEntity.setTitle(company.getTitle());
        return companyEntity;
    }

    public CompanyAddressEntity mapCompanyAddressDtoToEntity(Address address) {
        CompanyAddressEntity companyAddressEntity = new CompanyAddressEntity();
        companyAddressEntity.setCoordinates(mapCompanyCoordinatesDtoToEntity(address.getCoordinates()));
        companyAddressEntity.setAddress(address.getAddress());
        companyAddressEntity.setCity(address.getCity());
        companyAddressEntity.setCountry(address.getCity());
        companyAddressEntity.setState(address.getState());
        companyAddressEntity.setPostalCode(address.getPostalCode());
        companyAddressEntity.setStateCode(address.getStateCode());
        return companyAddressEntity;
    }

    public CompanyCoordinatesEntity mapCompanyCoordinatesDtoToEntity(Coordinates coordinates) {
        CompanyCoordinatesEntity companyCoordinatesEntity = new CompanyCoordinatesEntity();
        companyCoordinatesEntity.setLat(coordinates.getLat());
        companyCoordinatesEntity.setLng(coordinates.getLng());
        return  companyCoordinatesEntity;
    }

    public BankEntity mapBankDtoToEntity(Bank bank) {
        BankEntity bankEntity = new BankEntity();
        bankEntity.setCardExpire(bank.getCardExpire());
        bankEntity.setCardNumber(bank.getCardNumber());
        bankEntity.setIban(bank.getIban());
        bankEntity.setCurrency(bank.getCurrency());
        bankEntity.setCardType(bank.getCardType());
        return bankEntity;
    }

    public CryptoEntity mapCryptoDtoToEntity(Crypto crypto) {
        CryptoEntity cryptoEntity = new CryptoEntity();
        cryptoEntity.setCoin(crypto.getCoin());
        cryptoEntity.setNetwork(crypto.getNetwork());
        cryptoEntity.setWallet(crypto.getWallet());
        return cryptoEntity;
    }

    public AddressEntity mapAddressDTOToEntity(Address address) {
        AddressEntity addressEntity = new AddressEntity();
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity();
        addressEntity.setAddress(address.getAddress());
        addressEntity.setCity(address.getCity());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setState(address.getState());
        addressEntity.setPostalCode(address.getPostalCode());
        addressEntity.setStateCode(address.getStateCode());
        addressEntity.setCoordinates(mapCoordinatesDtoToEntity(address.getCoordinates()));
        return addressEntity;
    }

    public CoordinatesEntity mapCoordinatesDtoToEntity(Coordinates coordinates) {
        CoordinatesEntity coordinatesEntity = new CoordinatesEntity();
        coordinatesEntity.setLat(coordinates.getLat());
        coordinatesEntity.setLng(coordinates.getLng());
        return coordinatesEntity;
    }

    public HairEntity mapHairDTOtoEntity(Hair hair) {
        HairEntity hairEntity = new HairEntity();
        hairEntity.setColor(hair.getColor());
        hairEntity.setType(hair.getType());
        // Set properties for HairDTO based on HairEntity
        return hairEntity;
    }

    public UserResponse fetchUserByRole(String role) {
        List<UserEntity> userList = repository.findAllByRole(role);
        UserResponse userResponse = new UserResponse();
        if(Objects.nonNull(userList)) {
            userResponse.setUsers(mapUserEntityToDTO(userList));
            return userResponse;
        }
        return null;
    }

    public List<User> mapUserEntityToDTO(List<UserEntity> userList) {
        List<User> userListToReturn = new ArrayList<>();
        for(UserEntity userEntity : userList) {
            User user = new User();
            user.setId(userEntity.getId());
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());
            user.setMaidenName(userEntity.getMaidenName());
            user.setAge(userEntity.getAge());
            user.setGender(userEntity.getGender());
            user.setEmail(userEntity.getEmail());
            user.setPhone(userEntity.getPhone());
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            user.setBirthDate(userEntity.getBirthDate());
            user.setImage(userEntity.getImage());
            user.setBloodGroup(userEntity.getBloodGroup());
            user.setHeight(userEntity.getHeight());
            user.setWeight(userEntity.getWeight());
            user.setEyeColor(userEntity.getEyeColor());
            user.setIp(userEntity.getIp());

            if (userEntity.getHair() != null) {
                user.setHair(mapHairEntityToDTO(userEntity.getHair()));
            }

            user.setIp(userEntity.getIp());

            // Map AddressEntity to AddressDTO
            if (userEntity.getAddress() != null) {
                user.setAddress(mapAddressEntityToDTO(userEntity.getAddress()));
            }

            user.setMacAddress(userEntity.getMacAddress());
            user.setUniversity(userEntity.getUniversity());
            user.setEin(userEntity.getEin());
            user.setSsn(userEntity.getSsn());
            user.setUserAgent(userEntity.getUserAgent());

            // Map CryptoEntity to CryptoDTO
            if (userEntity.getCrypto() != null) {
                user.setCrypto(mapCryptoEntityToDTO(userEntity.getCrypto()));
            }

            user.setRole(userEntity.getRole());

            // Map BankEntity and CompanyEntity similarly
            if (userEntity.getBank() != null) {
                user.setBank(mapBankEntityToDTO(userEntity.getBank()));
            }

            if (userEntity.getCompany() != null) {
                user.setCompany(mapCompanyEntityToDTO(userEntity.getCompany()));
            }
            userListToReturn.add(user);
        }
        return userListToReturn;
    }

    public Company mapCompanyEntityToDTO(CompanyEntity company) {
        Company company1 = new Company();
        company1.setName(company.getName());
        company1.setTitle(company.getTitle());
        company1.setDepartment(company.getDepartment());
        company1.setAddress(mapCompanyAddressEntityToDTO(company.getAddress()));
        return company1;
    }

    public Address mapCompanyAddressEntityToDTO(CompanyAddressEntity address) {
        Address address1 = new Address();
        address1.setCoordinates(mapCompanyCoordinatesEntityToDTO(address.getCoordinates()));
        address1.setAddress(address.getAddress());
        address1.setCity(address.getCity());
        address1.setState(address.getState());
        address1.setCountry(address.getCountry());
        address1.setStateCode(address.getStateCode());
        address1.setPostalCode(address.getPostalCode());
        return address1;
    }

    public Coordinates mapCompanyCoordinatesEntityToDTO(CompanyCoordinatesEntity coordinates) {
        Coordinates coordinates1 = new Coordinates();
        coordinates1.setLng(coordinates.getLng());
        coordinates1.setLat(coordinates.getLat());
        return coordinates1;
    }

    public Bank mapBankEntityToDTO(BankEntity bank) {
        Bank bank1 = new Bank();
        bank1.setIban(bank.getIban());
        bank1.setCurrency(bank.getCurrency());
        bank1.setCardExpire(bank.getCardExpire());
        bank1.setCardNumber(bank.getCardNumber());
        bank1.setCardType(bank.getCardType());
        return bank1;
    }

    public Crypto mapCryptoEntityToDTO(CryptoEntity crypto) {
        Crypto crypto1 = new Crypto();
        crypto1.setCoin(crypto.getCoin());
        crypto1.setNetwork(crypto.getNetwork());
        crypto1.setWallet(crypto.getWallet());
        return crypto1;
    }

    public Address mapAddressEntityToDTO(AddressEntity address) {
        Address address1 = new Address();
        address1.setAddress(address.getAddress());
        address1.setState(address.getState());
        address1.setCity(address.getCity());
        address1.setCountry(address.getCountry());
        address1.setPostalCode(address.getPostalCode());
        address1.setStateCode(address.getStateCode());
        address1.setCoordinates(mapCoordinatesEntityToDTO(address.getCoordinates()));
        return address1;
    }

    public Coordinates mapCoordinatesEntityToDTO(CoordinatesEntity coordinates) {
        Coordinates coordinates1 = new Coordinates();
        coordinates1.setLat(coordinates.getLat());
        coordinates1.setLng(coordinates.getLng());
        return coordinates1;
    }

    public Hair mapHairEntityToDTO(HairEntity hair) {
        Hair hair1 = new Hair();
        hair1.setColor(hair.getColor());
        hair1.setType(hair.getType());
        return hair1;
    }

    public UserResponse fetchUserBySSN(String ssn) {
        List<UserEntity> userList = repository.findAllBySsn(ssn);
        UserResponse userResponse = new UserResponse();
        if(Objects.nonNull(userList)) {
            userResponse.setUsers(mapUserEntityToDTO(userList));
            return userResponse;
        }
        return null;
    }

    public UserResponse fetchSortedUsers(String order) {
        List<UserEntity> userList = repository.findAll();
        UserResponse userResponse = new UserResponse();
        List<UserEntity> sortedUsers = new ArrayList<>();
        if(Objects.nonNull(userList)) {
            if(order.equalsIgnoreCase("asc")) {
                sortedUsers = userList.stream()
                        .sorted(Comparator.comparingInt(UserEntity::getAge))  // Sorting by age
                        .toList();
            } if (order.equalsIgnoreCase("desc")) {
                sortedUsers = userList.stream()
                        .sorted(Comparator.comparingInt(UserEntity::getAge).reversed())  // Sorting by age
                        .toList();
            }
            if(!CollectionUtils.isEmpty(sortedUsers)) {
                userResponse.setUsers(mapUserEntityToDTO(sortedUsers));
                return userResponse;
            }
        }
        return null;
    }
}
