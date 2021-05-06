package com.tttn.quanlynhansu.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.tttn.quanlynhansu.model.BangCapChungChi;
import com.tttn.quanlynhansu.model.QuaTrinhCongTac;
import com.tttn.quanlynhansu.model.QuaTrinhDaoTao;
import com.tttn.quanlynhansu.model.ThongTinGiaDinh;
import com.tttn.quanlynhansu.repository.BangCapChungChiRepository;
import com.tttn.quanlynhansu.repository.QuaTrinhCongTacRepository;
import com.tttn.quanlynhansu.repository.QuaTrinhDaoTaoRepository;
import com.tttn.quanlynhansu.repository.ThongTinGiaDinhRepository;
import com.tttn.quanlynhansu.response.Response;
import com.tttn.quanlynhansu.service.BangCapChungChiService;
import com.tttn.quanlynhansu.service.DanhGiaNhanVienService;
import com.tttn.quanlynhansu.service.QuaTrinhCongTacService;
import com.tttn.quanlynhansu.service.QuaTrinhDaoTaoService;
import com.tttn.quanlynhansu.service.ThongTinGiaDinhService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ThongTinChiTietController {
	@Autowired
	private BangCapChungChiService bcccService;
	@Autowired
	private QuaTrinhCongTacService qtctService;
	@Autowired
	private QuaTrinhDaoTaoService qtdtService;
	@Autowired
	private ThongTinGiaDinhService ttgdService;

	@Autowired
	private BangCapChungChiRepository bcccRepo;
	@Autowired
	private QuaTrinhDaoTaoRepository qtdtRepo;
	@Autowired
	private QuaTrinhCongTacRepository qtctRepo;
	@Autowired
	private ThongTinGiaDinhRepository ttgdRepo;

	//==============bang cap chung chi===================
	@GetMapping("/bang-cap-chung-chi/{idnv}/{id}")
	public ResponseEntity getbangcap(@PathVariable(value = "id") Long id) {
		BangCapChungChi item = bcccRepo.findById(id).get();
		return new ResponseEntity(new Response(item, null), HttpStatus.OK);
	}

	@PutMapping("/bang-cap-chung-chi/{idnv}")
	public ResponseEntity updatebangcap(@RequestBody BangCapChungChi request,@PathVariable(value = "idnv") Long idnv) {
		BangCapChungChi newItem = bcccRepo.save(request);
		List<BangCapChungChi> list = bcccService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(newItem, list), HttpStatus.OK);
	}

	@PostMapping("/bang-cap-chung-chi/{idnv}")
	public ResponseEntity addbangcap(@RequestBody BangCapChungChi request,@PathVariable(value = "idnv") Long idnv) {
		BangCapChungChi newItem = bcccRepo.save(request);
		List<BangCapChungChi> list = bcccService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(newItem, list), HttpStatus.OK);
	}

	@DeleteMapping("/bang-cap-chung-chi/{id}/{idnv}")
	public ResponseEntity deletebc(@PathVariable(value = "id") Long id,@PathVariable(value = "idnv") Long idnv) {
		bcccRepo.deleteById(id);
		List<BangCapChungChi> list = bcccService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(null, list), HttpStatus.OK);
	}
	
	//================qua trinh cong tac===================

	@PutMapping("/qua-trinh-cong-tac/{idnv}")
	public ResponseEntity updatequatrinhct(@RequestBody QuaTrinhCongTac request,@PathVariable(value = "idnv") Long idnv) {
		QuaTrinhCongTac newItem = qtctRepo.save(request);
		List<QuaTrinhCongTac> list = qtctService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(newItem, list), HttpStatus.OK);
	}

	@DeleteMapping("/qua-trinh-cong-tac/{id}/{idnv}")
	public ResponseEntity deletequatrinhct(@PathVariable(value = "id") Long id,@PathVariable(value = "idnv") Long idnv) {
		QuaTrinhCongTac item = qtctRepo.findById(id).get();
		qtctRepo.deleteById(id);
		List<QuaTrinhCongTac> list = qtctService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(item, list), HttpStatus.OK);
	}

	@PostMapping("/qua-trinh-cong-tac/{idnv}")
	public ResponseEntity addquatrinhct(@RequestBody QuaTrinhCongTac request,@PathVariable(value = "idnv") Long idnv) {
		QuaTrinhCongTac newItem = qtctRepo.save(request);
		List<QuaTrinhCongTac> list = qtctService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(newItem, list), HttpStatus.OK);
	}
	
	//==============thong tin gia dinh===================
	@PutMapping("/thong-tin-gia-dinh/{idnv}")
	public ResponseEntity updatettgd(@RequestBody ThongTinGiaDinh request,@PathVariable(value = "idnv") Long idnv) {
		ThongTinGiaDinh newItem = ttgdRepo.save(request);
		List<ThongTinGiaDinh> list = ttgdService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(newItem, list), HttpStatus.OK);
	}

	@DeleteMapping("/thong-tin-gia-dinh/{id}/{idnv}")
	public ResponseEntity deletettgd(@PathVariable(value = "id") Long id,@PathVariable(value = "idnv") Long idnv) {
		ThongTinGiaDinh item = ttgdRepo.findById(id).get();
		ttgdRepo.deleteById(id);
		List<ThongTinGiaDinh> list = ttgdService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(item, list), HttpStatus.OK);
	}

	@PostMapping("/thong-tin-gia-dinh/{idnv}")
	public ResponseEntity addttgd(@RequestBody ThongTinGiaDinh request,@PathVariable(value = "idnv") Long idnv) {
		ThongTinGiaDinh newItem = ttgdRepo.save(request);
		List<ThongTinGiaDinh> list = ttgdService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(newItem, list), HttpStatus.OK);
	}
	
	//==============qua trinh dao tao===================
	@PutMapping("/qua-trinh-dao-tao/{idnv}")
	public ResponseEntity updateqtdt(@RequestBody QuaTrinhDaoTao request,@PathVariable(value = "idnv") Long idnv) {
		QuaTrinhDaoTao newItem = qtdtRepo.save(request);
		List<QuaTrinhDaoTao> list = qtdtService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(newItem, list), HttpStatus.OK);
	}

	@DeleteMapping("/qua-trinh-dao-tao/{id}/{idnv}")
	public ResponseEntity deleteqtdt(@PathVariable(value = "id") Long id,@PathVariable(value = "idnv") Long idnv) {
		QuaTrinhDaoTao item = qtdtRepo.findById(id).get();
		qtdtRepo.deleteById(id);
		List<QuaTrinhDaoTao> list = qtdtService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(item, list), HttpStatus.OK);
	}

	@PostMapping("/qua-trinh-dao-tao/{idnv}")
	public ResponseEntity addqtdt(@RequestBody QuaTrinhDaoTao request,@PathVariable(value = "idnv") Long idnv) {
		QuaTrinhDaoTao newItem = qtdtRepo.save(request);
		List<QuaTrinhDaoTao> list = qtdtService.findByNhanVienId(idnv);
		return new ResponseEntity(new Response(newItem, list), HttpStatus.OK);
	}
}
