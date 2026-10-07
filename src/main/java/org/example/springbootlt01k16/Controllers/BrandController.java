package org.example.springbootlt01k16.Controllers;

import org.example.springbootlt01k16.Services.BrandService;
import org.example.springbootlt01k16.entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Đánh dấu RestController: làm việc với Restful API, chỉ trả ra dữ liệu theo dạng JSON
@RestController
//Định nghĩa API
@RequestMapping("/brand")
@CrossOrigin(origins = "*")
public class BrandController {

    @Autowired
    public BrandService brandService;

    //Phương thức lấy toàn bộ dữ liệu
    @GetMapping
    public List<Brand> getAllBrand(){
        return brandService.getAllBrand();
    }

    //Phương thức lấy 1 bản ghi
    @GetMapping("/{Id}")
    public Brand getBrandById(@PathVariable Long Id){
        return brandService.getBrandById(Id);
    }

    //Phương thức để thêm dữ liệu
    @PostMapping("/create")
    public String createBrand(@RequestBody Brand brand){
        brandService.createBrand(brand);
        return "Thêm thành công";
    }

    //Phương thức để sửa dữ liệu
    @PutMapping("/{Id}")
    public String updateBrand(@PathVariable Long Id, @RequestBody Brand brand){
        brandService.updateBrand(Id, brand);
        return "Sửa thành công";
    }

    //Phương thức để xóa dữ liệu
    @DeleteMapping("/{Id}")
    public String deleteBrand(@PathVariable Long Id){
        brandService.deleteBrand(Id);
        return "Xóa thành công";
    }
}