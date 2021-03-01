package com.klayrocha.jmsproducer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klayrocha.jmsproducer.service.VehicleService;
import com.klayrocha.jmsproducer.vo.VehicleVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

	private final VehicleService vehicleService;

	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public VehicleVO create(@RequestBody VehicleVO vehicleVO) {
		VehicleVO veVO = vehicleService.create(vehicleVO);
		return veVO;
	}
}
