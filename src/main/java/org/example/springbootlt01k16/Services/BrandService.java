package org.example.springbootlt01k16.Services;

import org.example.springbootlt01k16.Repositories.BrandRepository;
import org.example.springbootlt01k16.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Đánh dấu Service
@Service
public class BrandService {

    //Đối tượng giúp làm việc với DB
    @Autowired
    public BrandRepository brandRepository;

    //Phương thức lấy tất cả bản ghi
    public List<Brand> getAllBrand(){
        return brandRepository.findAll();
    }

    //Phương thức lấy 1 bản ghi theo id
    public Brand getBrandById(Long Id){
        return brandRepository.findById(Id).orElseThrow(() -> new RuntimeException("Không có brand phù hợp"));
    }

    //Phương thức lưu dữ liệu
    public Brand createBrand(Brand brand){
        return brandRepository.save(brand);
    }

    //Phương thức sửa dữ liệu
    public Brand updateBrand(Long Id, Brand brand){
        Brand existingBrand = this.getBrandById(Id);
        existingBrand.setName(brand.getName());
        return brandRepository.save(existingBrand);
    }

    //Phương thức xóa dữ liệu
    public Brand deleteBrand(Long Id){
        Brand existingBrand = this.getBrandById(Id);
        brandRepository.deleteById(Id);
        return existingBrand;
    }
}