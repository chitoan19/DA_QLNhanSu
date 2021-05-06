package com.tttn.quanlynhansu.controller;


import java.io.IOException;

import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tttn.quanlynhansu.Utils.Util;
import com.tttn.quanlynhansu.model.BangCapChungChi;
import com.tttn.quanlynhansu.model.DanhGiaNhanVien;
import com.tttn.quanlynhansu.model.NhanVien;
import com.tttn.quanlynhansu.model.QuaTrinhCongTac;
import com.tttn.quanlynhansu.model.QuaTrinhDaoTao;
import com.tttn.quanlynhansu.model.ThongTinGiaDinh;
import com.tttn.quanlynhansu.repository.LuongRepository;
import com.tttn.quanlynhansu.request.NhanVienRequest;
import com.tttn.quanlynhansu.response.Response;
import com.tttn.quanlynhansu.service.BangCapChungChiService;
import com.tttn.quanlynhansu.service.DanhGiaNhanVienService;
import com.tttn.quanlynhansu.service.NhanVienService;
import com.tttn.quanlynhansu.service.QuaTrinhCongTacService;
import com.tttn.quanlynhansu.service.QuaTrinhDaoTaoService;
import com.tttn.quanlynhansu.service.ThongTinGiaDinhService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class NhanVienController {
	@Autowired
	private NhanVienService nvService;

	@Autowired
	private BangCapChungChiService bcccService;

	@Autowired
	private QuaTrinhCongTacService qtctService;

	@Autowired
	private QuaTrinhDaoTaoService qtdtService;
	
	@Autowired
	private ThongTinGiaDinhService ttgdService;

	@Autowired
	private DanhGiaNhanVienService danhGiaService;
	
	@PostMapping("/nhan-vien")
	public ResponseEntity getAllNhanVien(@RequestBody NhanVienRequest nvRequest) {
		List<NhanVien> list = nvService.findAll(nvRequest);
		return new ResponseEntity(new Response(null, list, nvService.totalItems), HttpStatus.OK);
	}

	@PostMapping("/nhan-vien/{id}")
	public ResponseEntity getNhanVien(@RequestBody NhanVien nv) {
		NhanVien selectedNv = nvService.getNhanVien(nv.getId());
		if(nv.getAnh() != null) {
			selectedNv.setAnh(Util.decompressBytes(selectedNv.getAnh()));
		}
		return new ResponseEntity(new Response(selectedNv, null, null), HttpStatus.OK);
	}

	@GetMapping("/nhan-vien/{id}")
	public ResponseEntity getNhanVien(@PathVariable("id") Long id) {
		NhanVien nv = nvService.getNhanVien(id);
		if(nv.getAnh() != null) {
			nv.setAnh(Util.decompressBytes(nv.getAnh()));
		}
		return new ResponseEntity(new Response(nv, null, null), HttpStatus.OK);
	}

	@PutMapping("/nhan-vien/{id}")
	public ResponseEntity editNhanVien(@RequestBody NhanVien nv, @PathVariable("id") Long id) {
		NhanVien oldNv = nvService.getNhanVien(id);
		nv.setAnh(oldNv.getAnh());
		NhanVien newNv = nvService.saveNhanVien(nv);
		//newNv.setAnh(Util.decompressBytes(newNv.getAnh()));
		return new ResponseEntity(new Response(newNv, null, null), HttpStatus.OK);
	}

	@DeleteMapping("/nhan-vien/{id}")
	public ResponseEntity delNhanVien(@PathVariable(value = "id") Long id) {
		nvService.delNhanVien(id);
		List<NhanVien> list = nvService.getAllNhanVien();
		return new ResponseEntity(new Response(null, list, null), HttpStatus.OK);
	}

	@PostMapping("/nhan-vien/add")
	public ResponseEntity createNhanVien(@RequestBody NhanVien nv) {
		// nv.setNgay_sinh(Util.stringToDate(nv.getNgay_sinh().toString()));
		NhanVien newNv = nvService.saveNhanVien(nv);
		List<NhanVien> list = nvService.getAllNhanVien();
		return new ResponseEntity(new Response(newNv, list, (long) list.size()), HttpStatus.OK);
	}

	@GetMapping("/nhan-vien/getall")
	public List<NhanVien> getall() {
		List<NhanVien> list = nvService.getAllNhanVien();
		return list;
	}

	@GetMapping("/thong-tin-gia-dinh/{id}")
	public ResponseEntity thongtingiadinh(@PathVariable(value = "id") Long id) {
		List<ThongTinGiaDinh> list = ttgdService.findByNhanVienId(id);
		return new ResponseEntity(new Response(null, list), HttpStatus.OK);
	}

	@GetMapping("/qua-trinh-dao-tao/{id}")
	public ResponseEntity quatrinhdaotao(@PathVariable(value = "id") Long id) {
		List<QuaTrinhDaoTao> list = qtdtService.findByNhanVienId(id);
		return new ResponseEntity(new Response(null, list), HttpStatus.OK);
	}

	@GetMapping("/qua-trinh-cong-tac/{id}")
	public ResponseEntity quatrinhcongtac(@PathVariable(value = "id") Long id) {
		List<QuaTrinhCongTac> list = qtctService.findByNhanVienId(id);
		return new ResponseEntity(new Response(null, list), HttpStatus.OK);
	}

	@GetMapping("/bang-cap-chung-chi/{id}")
	public ResponseEntity bangcap(@PathVariable(value = "id") Long id) {
		List<BangCapChungChi> list = bcccService.findByNhanVienId(id);
		return new ResponseEntity(new Response(null, list), HttpStatus.OK);
	}

	@GetMapping("/danh-gia-nhan-vien/{id}")
	public ResponseEntity danhgianhanvien(@PathVariable(value = "id") Long id) {
		List<DanhGiaNhanVien> list = danhGiaService.findByNhanVienId(id);
		return new ResponseEntity(new Response(null, list), HttpStatus.OK);
	}

	@PostMapping("/upload-avatar/{idnv}")
	public ResponseEntity uploadAvatar(@RequestParam("img") MultipartFile img, @PathVariable("idnv") Long idnv) {
		NhanVien nv = nvService.getNhanVien(idnv);
//		try {
//			File dir = new File(PATH_SAVE_FILE);
//			String pathFile = dir.getAbsolutePath();
//			File fileUpload = new File(pathFile.trim() + "/" + img.getOriginalFilename());
//			//img.transferTo(fileUpload);
//			FileInputStream fileInputStream = new FileInputStream(fileUpload);
//			String extension = img.getOriginalFilename().split("\\.")[1];
//			byte[] bytes = new byte[(int)fileUpload.length()];
//			fileInputStream.read(bytes);
//			String encodeBase64 = Base64.getEncoder().encodeToString(bytes);
//			nv.setAnh(("data:image/" + extension + ";base64," + encodeBase64).getBytes());
//			fileInputStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return new ResponseEntity(new Response(nv, null), HttpStatus.OK);
//		}
		byte[] avt = null;
		byte[] displayAvt = null;
		try {
			avt = Util.compressBytes(img.getBytes());
			nv.setAnh(avt);
			nvService.saveNhanVien(nv);
			displayAvt = Util.decompressBytes(avt);
			nv.setAnh(displayAvt);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity(new Response(nv, null), HttpStatus.OK);
	}

}
