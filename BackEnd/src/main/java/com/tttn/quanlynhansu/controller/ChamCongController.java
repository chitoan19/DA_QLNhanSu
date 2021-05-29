package com.tttn.quanlynhansu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tttn.quanlynhansu.dto.ChamCongDTO;
import com.tttn.quanlynhansu.model.ChamCong;
import com.tttn.quanlynhansu.model.NhanVien;
import com.tttn.quanlynhansu.model.TinhLuongThang;
import com.tttn.quanlynhansu.repository.ChamCongRepository;
import com.tttn.quanlynhansu.request.ChamCongRequest;
import com.tttn.quanlynhansu.request.NhanVienRequest;
import com.tttn.quanlynhansu.request.TinhLuongThangRequest;
import com.tttn.quanlynhansu.response.Response;
import com.tttn.quanlynhansu.service.ChamCongService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ChamCongController {
	@Autowired
	private ChamCongService ccService;

	@Autowired
	private ChamCongRepository repo;

	@Autowired
	private ServletContext context;

	@PostMapping("/cham-cong")
	public ResponseEntity findChamCongOf(@RequestBody ChamCongRequest request) {
		List<ChamCong> list = ccService.findAllOf(request);
		return new ResponseEntity(new Response(null, list, ccService.totalItems), HttpStatus.OK);
	}

	@PostMapping("/cham-cong/thong-ke")
	public ResponseEntity thongke(@RequestBody ChamCongRequest request) {
		List<TinhLuongThang> result = ccService.thongKeCongThang(request);
		return new ResponseEntity(new Response(null, result, (long) result.size()), HttpStatus.OK);
	}

	@PostMapping("/cham-cong/import-file")
	public ResponseEntity importFile(@RequestParam("file") MultipartFile file) {
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFm = new SimpleDateFormat("yyyy-MM-dd h:mm:ss a");
		List<ChamCong> listChamCong = new ArrayList<ChamCong>();
		try {
			InputStream isExcel = file.getInputStream();
			String contextPath = context.getRealPath("/xml/CHAM_CONG.xml");
			InputStream xmlInput = new FileInputStream(contextPath);
			XLSReader mainReader = ReaderBuilder.buildFromXML(xmlInput);
			List<ChamCongDTO> listData = new ArrayList<ChamCongDTO>();
			Map<String, Object> beans = new HashMap<String, Object>();
			beans.put("rows", listData);
			XLSReadStatus readStatus = mainReader.read(isExcel, beans);
			if (listData.isEmpty()) {
				String err = "empty";
				return new ResponseEntity(new Response(err, null), HttpStatus.OK);
			} else {
				for (ChamCongDTO chamCongDTO : listData) {
					ChamCong chamCong = new ChamCong();
					if (chamCongDTO.getGio_vao() != null) {
						chamCong.setGio_vao(timeFm.parse(chamCongDTO.getGio_vao()));
						if (timeFm.parse(chamCongDTO.getGio_vao()).getHours() > 8
								&& timeFm.parse(chamCongDTO.getGio_vao()).getMinutes() > 15) {
							chamCong.setTrang_thai(0);// di muon
						} else {
							chamCong.setTrang_thai(1);
						}
					}
					if (chamCongDTO.getGio_ra() != null) {
						chamCong.setGio_ra(timeFm.parse(chamCongDTO.getGio_ra()));
						if (timeFm.parse(chamCongDTO.getGio_ra()).getHours() - 18 > 0) {
							chamCong.setGio_lam_them(timeFm.parse(chamCongDTO.getGio_ra()).getHours() - 18);
						}
					}
					if (chamCongDTO.getNgay() != null) {
						chamCong.setNgay_thang(dateFm.parse(chamCongDTO.getNgay()));
						chamCong.setThang(dateFm.parse(chamCongDTO.getNgay()).getMonth() + 1);
						chamCong.setNam(dateFm.parse(chamCongDTO.getNgay()).getYear() + 1900);
					}
//					if (chamCongDTO.getTrang_thai() != null) {
//						chamCong.setTrang_thai((int) Integer.valueOf(chamCongDTO.getTrang_thai()));
//					}
					if (chamCongDTO.getNhan_vien_id() != null) {
						chamCong.setNhan_vien_id(Long.valueOf(chamCongDTO.getNhan_vien_id()));
					}
					listChamCong.add(chamCong);
				}
				repo.saveAll(listChamCong);
			}
		} catch (Exception e) {
			String err = "wrongformat";
			return new ResponseEntity(new Response(err, null), HttpStatus.OK);
		}

		return new ResponseEntity(new Response(null, repo.findAll()), HttpStatus.OK);
	}

	@PostMapping("/luong-thang/list")
	public ResponseEntity getListLuongThang(@RequestBody TinhLuongThangRequest request) {
		List<TinhLuongThang> result = ccService.findAllTinhLuong(request);
		return new ResponseEntity(new Response(null, result, ccService.totalItems), HttpStatus.OK);
	}

}
