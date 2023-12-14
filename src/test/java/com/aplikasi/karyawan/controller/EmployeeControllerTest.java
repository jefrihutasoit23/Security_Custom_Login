package com.aplikasi.karyawan.controller;

import com.aplikasi.karyawan.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //untuk write dan read data json
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getById() {
    }

    @Test
    void listQuizHeader() throws Exception {
        mockMvc.perform(
                get("/api/v1/employee/list")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andDo(result -> {
            System.out.println("result+"+result);
//            assertNotNull(merchants);
//            assertTrue(merchants.isEmpty());
        });
    }

    @Test
    void listQuizHeaderSpec() {
    }

    @Test
    void defaultJPA() {
    }

//    @Test
//    void testCreateMerchantSuccess() throws Exception {
//        CreateMerchantRequest request = new CreateMerchantRequest();
//        request.setMerchantName("Toko ABC");
//        request.setMerchantLocation("Jogja");
//        request.setOpen(true);
//
//        mockMvc.perform(
//                post("/api/merchants")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request))
//        ).andExpect(
//                status().isOk()
//        ).andDo(result -> {
//            WebResponse<MerchantResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
//            MerchantResponse createdMerchant = response.getData();
//
//            assertNotNull(createdMerchant);
//            assertNotNull(createdMerchant.getId());
//            assertEquals("Toko ABC", createdMerchant.getMerchantName());
//            assertEquals("Jogja", createdMerchant.getMerchantLocation());
//            assertTrue(createdMerchant.isOpen());
//        });
//    }
//
//    @Test
//    void testFlagMerchantSuccess() throws Exception {
//        Merchant merchant = new Merchant();
//        merchant.setMerchantName("Toko ABC");
//        merchant.setMerchantLocation("Jogja");
//        merchant.setOpen(true);
//        Merchant savedMerchant = merchantRepository.save(merchant);
//
//        UpdateFlagMerchantRequest request = new UpdateFlagMerchantRequest();
//        request.setFlag(true);
//
//        mockMvc.perform(
//                patch("/api/merchants/flag/{id}", savedMerchant.getId())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request))
//        ).andExpect(
//                status().isOk()
//        ).andDo(result -> {
//            WebResponse<MerchantResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
//            MerchantResponse flaggedMerchant = response.getData();
//
//            assertNotNull(flaggedMerchant);
//            assertEquals(savedMerchant.getId(), flaggedMerchant.getId());
//            assertTrue(flaggedMerchant.isOpen());
//        });
//    }
//
//    @Test
//    void testGetMerchantsAvailable() throws Exception {
//        // Create merchants
//        merchantService.create(new CreateMerchantRequest("Toko ABC", "Jogja", true));
//        merchantService.create(new CreateMerchantRequest("Toko XYZ", "Surabaya", false));
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .accept(MediaType.APPLICATION_JSON)
//        ).andExpect(
//                status().isOk()
//        ).andDo(result -> {
//            WebResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
//            List<MerchantResponse> merchants = response.getData();
//
//            assertNotNull(merchants);
//            assertEquals(2, merchants.size()); // Only one merchant is open
//        });
//    }
//
//    @Test
//    void testFlagMerchantNotFound() throws Exception {
//        UpdateFlagMerchantRequest request = new UpdateFlagMerchantRequest();
//        request.setFlag(false);
//
//        // UUID acak yang tidak ada di database
//        UUID nonExistentMerchantId = UUID.randomUUID();
//
//        mockMvc.perform(
//                patch("/api/merchants/flag/{id}", nonExistentMerchantId)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request))
//        ).andExpect(
//                status().isNotFound()
//        );
//    }
//
//    @Test
//    void testUpdateMerchantSuccess() throws Exception{
//
//        Merchant merchant = new Merchant();
//        merchant.setMerchantName("Toko Indra");
//        merchant.setMerchantLocation("Jogja");
//        merchant.setOpen(true);
//        Merchant savedMerchant = merchantRepository.save(merchant);
//
//        UpdateMerchantRequest request = new UpdateMerchantRequest();
//        request.setMerchantName("Toko Baru");
//        request.setMerchantLocation("Jakarta");
//        request.setOpen(false);
//
//        mockMvc.perform(
//                patch("/api/merchants/{id}", savedMerchant.getId())
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request))
//        ).andExpectAll(
//                status().isOk()
//        ).andDo(result -> {
//            WebResponse<MerchantResponse> response = objectMapper.readValue(
//                    result.getResponse().getContentAsString(), new TypeReference<>() {
//                    });
//            assertEquals("Toko Baru", response.getData().getMerchantName());
//            assertEquals("Jakarta", response.getData().getMerchantLocation());
//            assertFalse(response.getData().isOpen());
//        });
//    }
//
//    @Test
//    void testGetMerchantsEmptyList() throws Exception {
//        // Tidak ada merchant yang dibuat
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .accept(MediaType.APPLICATION_JSON)
//        ).andExpect(
//                status().isOk()
//        ).andDo(result -> {
//            WebResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {});
//            List<MerchantResponse> merchants = response.getData();
//
//            assertNotNull(merchants);
//            assertTrue(merchants.isEmpty());
//        });
//    }
//
//    @Test
//    void searchSuccess() throws Exception{
//
//        for (int i = 0; i<50; i++){
//
//            Merchant merchant = new Merchant();
//            merchant.setMerchantName("Toko Indra");
//            merchant.setMerchantLocation("Jogjakarta");
//            merchant.setOpen(true);
//            merchantRepository.save(merchant);
//        }
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .queryParam("merchantName", "Indra")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpectAll(
//                status().isOk()
//        ).andDo(result -> {
//            PagingResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});
//
//            assertEquals(10, response.getSize());
//            assertEquals(5, response.getTotalPage());
//            assertEquals(0, response.getCurrentPage());
//        });
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .queryParam("merchantLocation", "Jogja")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpectAll(
//                status().isOk()
//        ).andDo(result -> {
//            PagingResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});
//
//            assertEquals(10, response.getSize());
//            assertEquals(5, response.getTotalPage());
//            assertEquals(0, response.getCurrentPage());
//        });
//
//        mockMvc.perform(
//                get("/api/merchants")
//                        .queryParam("open", "true")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpectAll(
//                status().isOk()
//        ).andDo(result -> {
//            PagingResponse<List<MerchantResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});
//
//            assertEquals(10, response.getSize());
//            assertEquals(5, response.getTotalPage());
//            assertEquals(0, response.getCurrentPage());
//        });
//
//    }

}